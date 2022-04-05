package com.example.exercisejsonprocessingtwo.services;

import com.example.exercisejsonprocessingtwo.models.dtos.CarListPartsDto;
import com.example.exercisejsonprocessingtwo.models.dtos.CarToyotaDto;

import java.io.IOException;
import java.util.List;

public interface CarService {

    void seedCars() throws IOException;

    List<CarToyotaDto> getCarToyotaDtos();

    List<CarListPartsDto> getCarListPartsDtos();
}
