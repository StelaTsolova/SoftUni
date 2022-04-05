package com.example.exercisejsonprocessingtwo.services.impls;

import com.example.exercisejsonprocessingtwo.models.dtos.CarListPartsDto;
import com.example.exercisejsonprocessingtwo.models.dtos.seed.CarSeedDto;
import com.example.exercisejsonprocessingtwo.models.dtos.CarToyotaDto;
import com.example.exercisejsonprocessingtwo.models.entities.Car;
import com.example.exercisejsonprocessingtwo.models.entities.Part;
import com.example.exercisejsonprocessingtwo.repositories.CarRepository;
import com.example.exercisejsonprocessingtwo.repositories.PartRepository;
import com.example.exercisejsonprocessingtwo.services.CarService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessingtwo.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class CarServicesImpl implements CarService {

    private static final String CARS_NAME = "cars.json";

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public CarServicesImpl(CarRepository carRepository, PartRepository partRepository, Gson gson, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars() throws IOException {
        if (this.carRepository.count() == 0) {
            Arrays.stream(this.gson.fromJson(Files.readString(Path
                            .of(RESOURCES_FILES_PATH + CARS_NAME)), CarSeedDto[].class))
                    .map(carSeedDto -> {
                        Car car = this.modelMapper.map(carSeedDto, Car.class);

                        car.setParts(getRandomParts());

                        return car;
                    })
                    .forEach(this.carRepository::save);
        }
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
    public List<CarToyotaDto> getCarToyotaDtos() {
        return this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream().map(car -> this.modelMapper.map(car, CarToyotaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarListPartsDto> getCarListPartsDtos() {
        return this.carRepository.findAll().stream()
                .map(car -> this.modelMapper.map(car, CarListPartsDto.class))
                .collect(Collectors.toList());
    }
}
