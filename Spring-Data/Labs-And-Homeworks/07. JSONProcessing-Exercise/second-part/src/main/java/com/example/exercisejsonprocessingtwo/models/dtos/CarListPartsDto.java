package com.example.exercisejsonprocessingtwo.models.dtos;

import com.example.exercisejsonprocessingtwo.models.dtos.seed.CarPartDto;
import com.example.exercisejsonprocessingtwo.models.entities.Part;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarListPartsDto {

    @Expose
    private CarMakeDto car;
    @Expose
    private Set<CarPartDto> parts;

    public CarMakeDto getCar() {
        return car;
    }

    public void setCar(CarMakeDto car) {
        this.car = car;
    }

    public Set<CarPartDto> getParts() {
        return parts;
    }

    public void setParts(Set<CarPartDto> parts) {
        this.parts = parts;
    }
}
