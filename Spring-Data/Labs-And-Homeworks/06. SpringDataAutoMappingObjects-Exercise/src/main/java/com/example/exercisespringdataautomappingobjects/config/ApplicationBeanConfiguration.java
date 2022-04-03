package com.example.exercisespringdataautomappingobjects.config;

import com.example.exercisespringdataautomappingobjects.models.dtios.GameAddDto;
import com.example.exercisespringdataautomappingobjects.models.entities.Game;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<GameAddDto, Game>() {
            @Override
            protected void configure() {
                map().setImageThumbnail(source.getThumbnailURL());
            }
        });

        return modelMapper;
    }
}
