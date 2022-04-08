package com.example.exercisexmlprocessingtwo.services;

import com.example.exercisexmlprocessingtwo.models.dtos.localSuppliers.SupplierLocalRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.SupplierSeedDto;

import java.util.List;

public interface SupplierService {

    long getEntityCount();

    void seedSuppliers(List<SupplierSeedDto> suppliers);

    SupplierLocalRootDto getSupplierLocalRootDto();
}
