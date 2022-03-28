package com.example.springdataintro.services;

import com.example.springdataintro.exceptions.AccountNotExistException;
import com.example.springdataintro.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Long id) throws AccountNotExistException, InsufficientFundsException;

    void transferMoney(BigDecimal amount, Long id) throws AccountNotExistException;

    void transferBetweenAccounts(BigDecimal amount, Long fromId, Long toId) throws AccountNotExistException, InsufficientFundsException;
}
