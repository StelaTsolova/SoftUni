package com.example.exercisexmlprocessing.services;

import com.example.exercisexmlprocessing.models.dtos.usersAndProducts.UserProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.successfullySoldProducts.UserSoldProductsRootDto;
import com.example.exercisexmlprocessing.models.dtos.seed.UserSeedDto;
import com.example.exercisexmlprocessing.models.entities.User;

import java.util.List;

public interface UserService {

    long getEntityCount();

    void seedUsers(List<UserSeedDto> users);

    User findRandomUser();

    UserSoldProductsRootDto getUserSoldProductsRootDto();

    UserProductsRootDto getUserProductsRootDto();
}
