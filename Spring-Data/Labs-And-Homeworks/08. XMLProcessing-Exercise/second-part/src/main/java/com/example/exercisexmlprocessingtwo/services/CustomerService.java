package com.example.exercisexmlprocessingtwo.services;

import com.example.exercisexmlprocessingtwo.models.dtos.totalSalesByCustomer.CustomerTotalSalesRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.orderedCustomers.CustomerOrderedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CustomerSeedDto;

import java.util.List;

public interface CustomerService {

    long getEntityCount();

    void seedCustomers(List<CustomerSeedDto> customers);

    CustomerOrderedRootDto getCustomerOrderedRootDto();

    CustomerTotalSalesRootDto getCustomerTotalSalesRootDto();
}
