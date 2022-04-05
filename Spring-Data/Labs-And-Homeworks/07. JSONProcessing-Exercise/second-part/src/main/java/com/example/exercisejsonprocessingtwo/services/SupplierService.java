package com.example.exercisejsonprocessingtwo.services;

import com.example.exercisejsonprocessingtwo.models.dtos.SupplierLocalDto;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface SupplierService {

    void seedSuppliers() throws IOException;

    List<SupplierLocalDto> getSupplierLocalDtos();
}
