package com.example.exercisejsonprocessingtwo.models.dtos.seed;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CarPartDto {

    @Expose
    private String Name;
    @Expose
    private BigDecimal Price;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
