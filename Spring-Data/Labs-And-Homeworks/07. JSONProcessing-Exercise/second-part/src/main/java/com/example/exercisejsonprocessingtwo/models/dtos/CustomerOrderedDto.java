package com.example.exercisejsonprocessingtwo.models.dtos;

import com.example.exercisejsonprocessingtwo.models.entities.Sale;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerOrderedDto {

    @Expose
    private Long Id;
    @Expose
    private String Name;
    @Expose
    private String BirthDate;
    @Expose
    private boolean IsYoungDriver;
    @Expose
    private Set<Sale> Sales;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return IsYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        IsYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return Sales;
    }

    public void setSales(Set<Sale> sales) {
        Sales = sales;
    }
}
