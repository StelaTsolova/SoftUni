package com.example.exercisejsonprocessingtwo.services;

import com.example.exercisejsonprocessingtwo.models.dtos.CustomerOrderedDto;
import com.example.exercisejsonprocessingtwo.models.dtos.CustomerTotalSalesDtos;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void seedCustomers() throws IOException;

    List<CustomerOrderedDto> getCustomerOrderedDtos();

    List<CustomerTotalSalesDtos> getCustomerTotalSalesDtos();
}
