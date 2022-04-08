package com.example.exercisexmlprocessingtwo.repositories;

import com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota.CarToyotaDto;
import com.example.exercisexmlprocessingtwo.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT new com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota." +
            "CarToyotaDto(c.id,c.make, c.model, c.travelledDistance) FROM Car c " +
            "WHERE c.make = 'Toyota' ORDER BY c.model, c.travelledDistance DESC")
    List<CarToyotaDto> findAllByMakeToyotaOrderByModelThanTravelledDistanceDesc();
}
