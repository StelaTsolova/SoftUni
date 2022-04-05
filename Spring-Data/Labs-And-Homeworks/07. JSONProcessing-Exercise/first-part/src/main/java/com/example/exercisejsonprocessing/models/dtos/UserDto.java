package com.example.exercisejsonprocessing.models.dtos;

import com.google.gson.annotations.Expose;

public class UserDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private UserSoldProductsDto soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserSoldProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(UserSoldProductsDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
