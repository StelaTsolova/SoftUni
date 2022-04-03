package com.example.exercisespringdataautomappingobjects.services.Impls;

import com.example.exercisespringdataautomappingobjects.models.dtios.GameAddDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameAllDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameDetailsDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameEditDto;
import com.example.exercisespringdataautomappingobjects.models.entities.Game;
import com.example.exercisespringdataautomappingobjects.repositories.GameRepository;
import com.example.exercisespringdataautomappingobjects.services.GameService;
import com.example.exercisespringdataautomappingobjects.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository, ValidationUtil validationUtil,
                           ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<String> addGame(GameAddDto addGameDto) {
        Set<ConstraintViolation<GameAddDto>> constraintViolations =
                this.validationUtil.violations(addGameDto);

        if (!constraintViolations.isEmpty()) {
            return constraintViolations.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }

        Game game = this.modelMapper.map(addGameDto, Game.class);

        this.gameRepository.save(game);

        return Set.of("Added " + addGameDto.getTitle());
    }

    @Override
    public Set<String> editGame(String id, GameEditDto gameEditDto) {

        Set<ConstraintViolation<GameEditDto>> constraintViolations =
                this.validationUtil.violations(gameEditDto);
        if (!constraintViolations.isEmpty()) {
            return constraintViolations.stream().map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }

        Game game = this.gameRepository.findGameById(Long.parseLong(id));

        if (game == null) {
            return Set.of("Invalid id");
        }

        this.modelMapper.map(gameEditDto, game);

        this.gameRepository.save(game);

        return Set.of("Edited " + game.getTitle());
    }

    @Override
    public String deleteGameById(String id) {
        Game game = this.gameRepository.findGameById(Long.parseLong(id));

        if (game == null) {
            return "Invalid id";
        }

        this.gameRepository.delete(game);

        return "Deleted " + game.getTitle();
    }

    @Override
    public Set<GameAllDto> getAllGameTitlesAndPrices() {

        return this.gameRepository.findAll().stream()
                .map(game -> this.modelMapper.map(game, GameAllDto.class)).collect(Collectors.toSet());
    }

    @Override
    public GameDetailsDto getDetailsByTiTle(String title) {
        return this.modelMapper.map(this.gameRepository.findGameByTitle(title), GameDetailsDto.class);
    }
}
