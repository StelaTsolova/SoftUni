package com.example.exercisejsonprocessing.models.dtos;

import com.example.exercisejsonprocessing.models.entities.User;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductRangeDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
