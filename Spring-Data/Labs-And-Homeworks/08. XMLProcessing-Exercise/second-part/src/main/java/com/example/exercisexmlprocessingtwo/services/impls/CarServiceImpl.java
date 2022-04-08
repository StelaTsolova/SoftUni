package com.example.exercisexmlprocessingtwo.services.impls;

import com.example.exercisexmlprocessingtwo.models.dtos.carsWithTheirListOfParts.CarPartsListDto;
import com.example.exercisexmlprocessingtwo.models.dtos.carsWithTheirListOfParts.CarPartsListRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota.CarToyotaRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CarSeedDto;
import com.example.exercisexmlprocessingtwo.models.entities.Car;
import com.example.exercisexmlprocessingtwo.models.entities.Part;
import com.example.exercisexmlprocessingtwo.repositories.CarRepository;
import com.example.exercisexmlprocessingtwo.repositories.PartRepository;
import com.example.exercisexmlprocessingtwo.services.CarService;
import com.example.exercisexmlprocessingtwo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final PartRepository partRepository;

    public CarServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                          CarRepository carRepository, PartRepository partRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
        this.partRepository = partRepository;
    }

    @Override
    public long getEntityCount() {
        return this.carRepository.count();
    }

    @Override
    public void seedCars(List<CarSeedDto> cars) {
        cars.stream().filter(this.validator::isValid)
                .map(carSeedDto -> {
                    Car car = this.modelMapper.map(carSeedDto, Car.class);
                    car.setParts(getRandomParts());

                    return car;
                })
                .forEach(this.carRepository::save);

    }

    private Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();

        int randomCount = ThreadLocalRandom.current().nextInt(3, 6);

        for (int i = 0; i < randomCount; i++) {
            parts.add(this.partRepository.findById(ThreadLocalRandom
                            .current().nextLong(1, this.partRepository.count() + 1))
                    .orElse(null));
        }

        while (parts.size() < 3) {
            parts.add(this.partRepository.findById(ThreadLocalRandom
                            .current().nextLong(1, this.partRepository.count() + 1))
                    .orElse(null));
        }

        return parts;
    }

    @Override
    public CarToyotaRootDto getCarToyotaRootDto() {
        CarToyotaRootDto rootDto = new CarToyotaRootDto();
        rootDto.setCars(this.carRepository.findAllByMakeToyotaOrderByModelThanTravelledDistanceDesc());

        return rootDto;
    }

    @Override
    public CarPartsListRootDto getCarPartsListRootDto() {
        CarPartsListRootDto rootDto = new CarPartsListRootDto();
        rootDto.setParts(this.carRepository.findAll().stream()
                .map(car -> this.modelMapper.map(car, CarPartsListDto.class))
                .collect(Collectors.toList()));

        return rootDto;
    }
}
