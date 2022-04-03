package com.example.exercisespringdataautomappingobjects.services;

import com.example.exercisespringdataautomappingobjects.models.dtios.GameAddDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameAllDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameDetailsDto;
import com.example.exercisespringdataautomappingobjects.models.dtios.GameEditDto;

import java.util.Set;

public interface GameService {

    Set<String> addGame(GameAddDto addGameDto);

    Set<String> editGame(String id, GameEditDto gameEditDto);

    String deleteGameById(String id);

    Set<GameAllDto> getAllGameTitlesAndPrices();

    GameDetailsDto getDetailsByTiTle(String title);
}
