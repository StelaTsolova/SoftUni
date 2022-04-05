package com.example.exercisejsonprocessing.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class UserAndProductsDto {

    @Expose
    private int usersCount;
    @Expose
    List<UserDto> users;

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
