package com.example.exercisejsonprocessingtwo.services.impls;

import com.example.exercisejsonprocessingtwo.models.dtos.seed.PartSeedDto;
import com.example.exercisejsonprocessingtwo.models.entities.Part;
import com.example.exercisejsonprocessingtwo.repositories.PartRepository;
import com.example.exercisejsonprocessingtwo.repositories.SupplierRepository;
import com.example.exercisejsonprocessingtwo.services.PartService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.exercisejsonprocessingtwo.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class PartServiceImpl implements PartService {

    private static final String PARTS_NAME = "parts.json";

    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository,
                           Gson gson, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;

        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedParts() throws IOException {
        if (this.partRepository.count() == 0) {
            Arrays.stream(this.gson.fromJson(Files.readString(Path
                            .of(RESOURCES_FILES_PATH + PARTS_NAME)), PartSeedDto[].class))
                    .map(partSeedDto -> {
                        Part part = this.modelMapper.map(partSeedDto, Part.class);

                        part.setSupplier(this.supplierRepository
                                .findById(ThreadLocalRandom.current()
                                        .nextLong(1, this.supplierRepository.count() + 1))
                                .orElse(null));

                        return part;
                    })
                    .forEach(this.partRepository::save);
        }
    }
}
