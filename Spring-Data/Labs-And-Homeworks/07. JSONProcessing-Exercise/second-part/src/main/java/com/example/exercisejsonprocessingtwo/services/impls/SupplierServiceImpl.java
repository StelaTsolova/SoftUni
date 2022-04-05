package com.example.exercisejsonprocessingtwo.services.impls;

import com.example.exercisejsonprocessingtwo.models.dtos.SupplierLocalDto;
import com.example.exercisejsonprocessingtwo.models.dtos.seed.SupplierSeedDto;
import com.example.exercisejsonprocessingtwo.models.entities.Part;
import com.example.exercisejsonprocessingtwo.models.entities.Supplier;
import com.example.exercisejsonprocessingtwo.repositories.SupplierRepository;
import com.example.exercisejsonprocessingtwo.services.SupplierService;
import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessingtwo.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String SUPPLIERS_NAME = "suppliers.json";

    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson,
                               ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepository.count() == 0) {
            Arrays.stream(this.gson.fromJson(Files.readString(Path
                            .of(RESOURCES_FILES_PATH + SUPPLIERS_NAME)), SupplierSeedDto[].class))
                    .map(SupplierSeedDto -> this.modelMapper.map(SupplierSeedDto, Supplier.class))
                    .forEach(this.supplierRepository::save);
        }
    }

    @Override
    public List<SupplierLocalDto> getSupplierLocalDtos() {
        Converter<Set<Part>, Integer> converter = new Converter<Set<Part>, Integer>() {
            @Override
            public Integer convert(MappingContext<Set<Part>, Integer> mappingContext) {
                return mappingContext.getSource().size();
            }
        };

        this.modelMapper.createTypeMap(Supplier.class, SupplierLocalDto.class)
                .addMappings(mapping -> mapping.using(converter)
                        .map(Supplier::getParts, SupplierLocalDto::setPartsCount));

        return this.supplierRepository.findAllByImporterIsFalse()
                .stream().map(supplier -> this.modelMapper.map(supplier, SupplierLocalDto.class))
                .collect(Collectors.toList());
    }
}
