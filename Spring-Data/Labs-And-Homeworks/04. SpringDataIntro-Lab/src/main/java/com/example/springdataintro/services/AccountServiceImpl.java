package com.example.springdataintro.services;

import com.example.springdataintro.exceptions.AccountNotExistException;
import com.example.springdataintro.exceptions.InsufficientFundsException;
import com.example.springdataintro.models.Account;
import com.example.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws AccountNotExistException, InsufficientFundsException {
        Account account = this.getAccount(id);

        if (account.getBalance().compareTo(amount) < 0){
            throw new InsufficientFundsException();
        }

        account.setBalance(account.getBalance().subtract(amount));

        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) throws AccountNotExistException {
        Account account = this.getAccount(id);

        account.setBalance(account.getBalance().add(amount));

        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferBetweenAccounts(BigDecimal amount, Long fromId, Long toId) throws AccountNotExistException, InsufficientFundsException {
        this.withdrawMoney(amount, fromId);

        this.transferMoney(amount, toId);
    }

    private Account getAccount(Long id) throws AccountNotExistException {
        return this.accountRepository.findById(id).orElseThrow(AccountNotExistException::new);
    }
}
