package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_NAME = "src/main/resources/files/json/towns.json";

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    public TownServiceImpl(Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper,
                           TownRepository townRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_NAME));
    }

    @Override
    public String importTowns() throws IOException {
        List<String> massages = new ArrayList<>();

        Arrays.stream(this.gson.fromJson(readTownsFileContent(), TownSeedDto[].class))
                .filter(townSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(townSeedDto) && !isExistByTownName(townSeedDto.getTownName());
                    if (isValid) {
                        massages.add(String.format("Successfully imported town %s - %d",
                                townSeedDto.getTownName(), townSeedDto.getPopulation()));
                    } else {
                        massages.add("Invalid town");
                    }

                    return isValid;
                })
                .map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(this.townRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isExistByTownName(String townName) {
        return this.townRepository.existsByTownName(townName);
    }

    @Override
    public Town getTownByName(String townName) {
        return this.townRepository.findByTownName(townName);
    }
}
