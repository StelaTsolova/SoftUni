package com.example.springdataintro;

import com.example.springdataintro.services.AccountService;
import com.example.springdataintro.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {

       // this.userService.registerUser("Pesho", 29, new BigDecimal(1300));

        try {
            this.accountService.transferBetweenAccounts(new BigDecimal(200), 1L, 3L);
        } catch (Exception exception){
            System.out.println(exception.getClass().getSimpleName());
        }
    }
}
