package com.example.exercisespringdataintrotwo.services;

import com.example.exercisespringdataintrotwo.models.User;

import java.util.Set;

public interface UserService {

    void persistUsers();

    Set<String> getAllUsernamesAndEmailsWithProvider(String provider);
}
