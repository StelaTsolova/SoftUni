package com.example.exercisespringdataautomappingobjects.services;

import com.example.exercisespringdataautomappingobjects.models.dtios.UserLoginDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.UserRegisterDto;

import java.util.Set;

public interface UserService {

    Set<String> registerUser(UserRegisterDto userRegisterDto);

    String loginUser(UserLoginDto userLoginDto);

    String logout();

    void buyGame(Long userId, Long gameId);

    Set<String> getLoggedInUserGameTitles();

    String addItemInCart(String gameTitle);

    String removeItemFromCart(String gameTitle);

    Set<String> buyItem();
}
