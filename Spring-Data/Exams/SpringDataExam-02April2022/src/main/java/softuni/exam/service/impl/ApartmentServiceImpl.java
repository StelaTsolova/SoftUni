package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.ApartmentSeedDto;
import softuni.exam.models.dto.xml.ApartmentSeedRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private static final String APARTMENTS_FILE_NAME = "src/main/resources/files/xml/apartments.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper,
                                TownService townService, ApartmentRepository apartmentRepository) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_FILE_NAME));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        ApartmentSeedRootDto apartmentSeedRootDto = (ApartmentSeedRootDto) JAXBContext
                .newInstance(ApartmentSeedRootDto.class)
                .createUnmarshaller()
                .unmarshal(new FileReader(APARTMENTS_FILE_NAME));

        List<String> massages = new ArrayList<>();
        apartmentSeedRootDto.getApartments().stream().filter(apartmentSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(apartmentSeedDto) && !isEntityExists(apartmentSeedDto);
                    if (isValid) {
                        massages.add(String.format("Successfully imported apartment %s - %.2f",
                                apartmentSeedDto.getApartmentType(), apartmentSeedDto.getArea()));
                    } else {
                        massages.add("Invalid apartment");
                    }

                    return isValid;
                })
                .map(apartmentSeedDto -> {
                    Apartment apartment = this.modelMapper.map(apartmentSeedDto, Apartment.class);
                    apartment.setApartmentType(ApartmentType.valueOf(apartmentSeedDto.getApartmentType().toUpperCase()));
                    apartment.setTown(this.townService.getTownByName(apartmentSeedDto.getTown()));

                    return apartment;
                })
                .forEach(this.apartmentRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isEntityExists(ApartmentSeedDto apartmentSeedDto) {
        return this.apartmentRepository.existsByTown_TownName(apartmentSeedDto.getTown())
                && this.apartmentRepository.existsByArea(apartmentSeedDto.getArea());
    }

    @Override
    public Apartment getApartmentById(long id) {
        return this.apartmentRepository.findById(id).orElseThrow();
    }
}
