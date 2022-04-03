package com.example.exercisespringdataautomappingobjects.models.dtios;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class GameEditDto {

    private BigDecimal price;
    private double size;

    public GameEditDto(){

    }

    public GameEditDto(BigDecimal price, double size) {
        this.price = price;
        this.size = size;
    }

    @Positive(message = "Enter positive price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive(message = "Enter positive size")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
