package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    private static final String AGENTS_FILE_NAME = "src/main/resources/files/json/agents.json";

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final AgentRepository agentRepository;

    public AgentServiceImpl(Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper,
                            TownService townService, AgentRepository agentRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.agentRepository = agentRepository;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_NAME));
    }

    @Override
    public String importAgents() throws IOException {
        List<String> massages = new ArrayList<>();

        Arrays.stream(this.gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class))
                .filter(agentSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(agentSeedDto) && !isExistsByFirstName(agentSeedDto.getFirstName());
                    if (isValid) {
                        massages.add(String.format("Successfully imported agent - %s %s",
                                agentSeedDto.getFirstName(), agentSeedDto.getLastName()));
                    } else {
                        massages.add("Invalid agent");
                    }

                    return isValid;
                })
                .map(agentSeedDto -> {
                    Agent agent = this.modelMapper.map(agentSeedDto, Agent.class);
                    agent.setTown(this.townService.getTownByName(agentSeedDto.getTown()));

                    return agent;
                })
                .forEach(this.agentRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    @Override
    public boolean isExistsByFirstName(String firstName) {
        return this.agentRepository.existsByFirstName(firstName);
    }

    @Override
    public Agent getAgentByFirstName(String firstName) {
        return this.agentRepository.findByFirstName(firstName);
    }
}
