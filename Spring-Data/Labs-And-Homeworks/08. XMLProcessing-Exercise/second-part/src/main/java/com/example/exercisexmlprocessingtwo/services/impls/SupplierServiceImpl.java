package com.example.exercisexmlprocessingtwo.services.impls;

import com.example.exercisexmlprocessingtwo.models.dtos.localSuppliers.SupplierLocalDto;
import com.example.exercisexmlprocessingtwo.models.dtos.localSuppliers.SupplierLocalRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.SupplierSeedDto;
import com.example.exercisexmlprocessingtwo.models.entities.Supplier;
import com.example.exercisexmlprocessingtwo.repositories.SupplierRepository;
import com.example.exercisexmlprocessingtwo.services.SupplierService;
import com.example.exercisexmlprocessingtwo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                               SupplierRepository supplierRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public long getEntityCount() {
        return this.supplierRepository.count();
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> suppliers) {
        suppliers.stream().filter(this.validator::isValid)
                .map(supplierSeedDto -> this.modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(this.supplierRepository::save);
    }

    @Override
    public SupplierLocalRootDto getSupplierLocalRootDto() {
        SupplierLocalRootDto rootDto = new SupplierLocalRootDto();
        rootDto.setSuppliers(this.supplierRepository.findAllByImporterIsFalse().stream()
                .map(supplier -> {
                    SupplierLocalDto dto = this.modelMapper.map(supplier, SupplierLocalDto.class);
                    dto.setPartsCount(supplier.getParts().size());

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }
}
