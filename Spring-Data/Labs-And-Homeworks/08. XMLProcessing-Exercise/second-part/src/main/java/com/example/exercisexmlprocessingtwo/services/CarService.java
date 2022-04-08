package com.example.exercisexmlprocessingtwo.services;

import com.example.exercisexmlprocessingtwo.models.dtos.carsWithTheirListOfParts.CarPartsListRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota.CarToyotaRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CarSeedDto;

import java.util.List;

public interface CarService {

    long getEntityCount();

    void seedCars(List<CarSeedDto> cars);

    CarToyotaRootDto getCarToyotaRootDto();

    CarPartsListRootDto getCarPartsListRootDto();
}
