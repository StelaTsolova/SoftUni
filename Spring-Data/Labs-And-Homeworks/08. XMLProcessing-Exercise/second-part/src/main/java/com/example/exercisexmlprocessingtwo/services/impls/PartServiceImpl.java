package com.example.exercisexmlprocessingtwo.services.impls;

import com.example.exercisexmlprocessingtwo.models.dtos.seed.PartSeedDto;
import com.example.exercisexmlprocessingtwo.models.entities.Part;
import com.example.exercisexmlprocessingtwo.repositories.PartRepository;
import com.example.exercisexmlprocessingtwo.repositories.SupplierRepository;
import com.example.exercisexmlprocessingtwo.services.PartService;
import com.example.exercisexmlprocessingtwo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;

    public PartServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                           PartRepository partRepository, SupplierRepository supplierRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public long getEntityCount() {
        return this.partRepository.count();
    }

    @Override
    public void seedParts(List<PartSeedDto> parts) {
        parts.stream().filter(this.validator::isValid)
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
