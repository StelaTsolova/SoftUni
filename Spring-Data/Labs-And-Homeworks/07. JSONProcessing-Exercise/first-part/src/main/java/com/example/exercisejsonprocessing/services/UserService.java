package com.example.exercisejsonprocessing.services;

import com.example.exercisejsonprocessing.models.dtos.UserAndProductsDto;
import com.example.exercisejsonprocessing.models.dtos.UserSoldDto;
import com.example.exercisejsonprocessing.models.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUserSoldDtos();

    UserAndProductsDto findAllUserAndProductsDtos();
}
