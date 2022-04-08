package com.example.exercisexmlprocessingtwo.services.impls;

import com.example.exercisexmlprocessingtwo.models.dtos.totalSalesByCustomer.CustomerTotalSalesDto;
import com.example.exercisexmlprocessingtwo.models.dtos.totalSalesByCustomer.CustomerTotalSalesRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.orderedCustomers.CustomerOrderedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CustomerSeedDto;
import com.example.exercisexmlprocessingtwo.models.entities.Customer;
import com.example.exercisexmlprocessingtwo.models.entities.Sale;
import com.example.exercisexmlprocessingtwo.repositories.CustomerRepository;
import com.example.exercisexmlprocessingtwo.services.CustomerService;
import com.example.exercisexmlprocessingtwo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(ValidationUtil validator, ModelMapper modelMapper,
                               CustomerRepository customerRepository) {
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public long getEntityCount() {
        return this.customerRepository.count();
    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> customers) {
        customers.stream().filter(this.validator::isValid)
                .map(customerSeedDto -> this.modelMapper.map(customerSeedDto, Customer.class))
                .forEach(this.customerRepository::save);
    }

    @Override
    public CustomerOrderedRootDto getCustomerOrderedRootDto() {
        CustomerOrderedRootDto rootDto = new CustomerOrderedRootDto();
        rootDto.setCustomers(this.customerRepository.findAllOrderedByBirthDateThanIsYoungDriver());

        return rootDto;
    }

    @Override
    public CustomerTotalSalesRootDto getCustomerTotalSalesRootDto() {
        CustomerTotalSalesRootDto rootDto = new CustomerTotalSalesRootDto();
        rootDto.setCustomers(this.customerRepository.findAllBySalesIsNotNullOrderByTotalPriceThanCountSalesDesc()
                .stream().map(customer -> {
                    CustomerTotalSalesDto dto = this.modelMapper.map(customer, CustomerTotalSalesDto.class);
                    dto.setBoughtCars(customer.getSales().size());
                    dto.setSpentMoney(getSum(customer.getSales()));

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }

    public static BigDecimal getSum(Set<Sale> sales) {
        BigDecimal sum = new BigDecimal(0);

        for (Sale sale : sales) {
            sum = sum.add(sale.getCar().getPrice());
        }

        return sum;
    }
}
