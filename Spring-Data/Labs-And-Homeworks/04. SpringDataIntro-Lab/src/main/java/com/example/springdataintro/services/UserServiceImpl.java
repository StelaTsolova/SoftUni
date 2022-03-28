package com.example.springdataintro.services;

import com.example.springdataintro.exceptions.UsernameAlreadyExistsException;
import com.example.springdataintro.models.Account;
import com.example.springdataintro.models.User;
import com.example.springdataintro.repositories.AccountRepository;
import com.example.springdataintro.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerUser(String username, int age, BigDecimal initialAmount) throws UsernameAlreadyExistsException {
        if (this.userRepository.existsByUsername(username)){
            throw new UsernameAlreadyExistsException();
        }

        User user = new User();
        user.setUsername(username);
        user.setAge(age);

        this.userRepository.save(user);

        Account firstAccount = new Account();
        firstAccount.setBalance(initialAmount);

        firstAccount.setUser(user);

        this.accountRepository.save(firstAccount);
    }
}
