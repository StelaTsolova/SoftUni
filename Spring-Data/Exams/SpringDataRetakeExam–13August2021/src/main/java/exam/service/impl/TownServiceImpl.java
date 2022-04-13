package exam.service.impl;

import exam.model.dto.xml.TownSeedRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private static final String TOWNS_FILE_NAME = "src/main/resources/files/xml/towns.xml";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    public TownServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper,
                           TownRepository townRepository) {
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
    public String importTowns() throws JAXBException, FileNotFoundException {
        TownSeedRootDto townSeedRootDto = (TownSeedRootDto) JAXBContext
                .newInstance(TownSeedRootDto.class)
                .createUnmarshaller()
                .unmarshal(new FileReader(TOWNS_FILE_NAME));

        List<String> massages = new ArrayList<>();
        townSeedRootDto.getTowns().stream().filter(townSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(townSeedDto);
                    if (isValid) {
                        massages.add("Successfully imported Town " + townSeedDto.getName());
                    } else {
                        massages.add("Invalid town");
                    }

                    return isValid;
                })
                .map(townSeedDto -> this.modelMapper.map(townSeedDto, Town.class))
                .forEach(this.townRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.getTownByName(name);
    }
}
