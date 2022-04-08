package com.example.exercisexmlprocessingtwo.services;

import com.example.exercisexmlprocessingtwo.models.dtos.seed.PartSeedDto;

import java.util.List;

public interface PartService {

    long getEntityCount();

    void seedParts(List<PartSeedDto> parts);
}
