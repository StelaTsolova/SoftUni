package com.example.exercisejsonprocessingtwo.configs;

import com.example.exercisejsonprocessingtwo.models.dtos.CustomerTotalSalesDtos;
import com.example.exercisejsonprocessingtwo.models.dtos.SaleDiscountDto;
import com.example.exercisejsonprocessingtwo.models.entities.Customer;
import com.example.exercisejsonprocessingtwo.models.entities.Sale;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Set;

@Configuration
public class ApplicationBeanConfigurations {

    @Bean
    public Gson gson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
