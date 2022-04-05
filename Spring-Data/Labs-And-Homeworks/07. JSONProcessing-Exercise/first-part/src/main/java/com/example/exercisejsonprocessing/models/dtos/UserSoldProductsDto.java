package com.example.exercisejsonprocessing.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserSoldProductsDto {

    @Expose
    private int count;
    @Expose
    private Set<UserProductsDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<UserProductsDto> getProducts() {
        return products;
    }

    public void setProducts(Set<UserProductsDto> products) {
        this.products = products;
    }
}
