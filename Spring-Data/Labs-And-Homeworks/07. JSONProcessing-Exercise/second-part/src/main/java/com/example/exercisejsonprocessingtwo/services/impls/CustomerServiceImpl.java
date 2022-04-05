package com.example.exercisejsonprocessingtwo.services.impls;

import com.example.exercisejsonprocessingtwo.models.dtos.CustomerOrderedDto;
import com.example.exercisejsonprocessingtwo.models.dtos.CustomerTotalSalesDtos;
import com.example.exercisejsonprocessingtwo.models.dtos.seed.CustomerSeedDto;
import com.example.exercisejsonprocessingtwo.models.entities.Customer;
import com.example.exercisejsonprocessingtwo.models.entities.Sale;
import com.example.exercisejsonprocessingtwo.repositories.CustomerRepository;
import com.example.exercisejsonprocessingtwo.services.CustomerService;
import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessingtwo.constants.GlobalConstants.RESOURCES_FILES_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMERS_NAME = "customers.json";

    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers() throws IOException {
        if (this.customerRepository.count() == 0) {
            Converter<String, LocalDateTime> converter = new Converter<String, LocalDateTime>() {
                @Override
                public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                    return mappingContext.getSource() == null
                            ? LocalDateTime.now()
                            : LocalDateTime.parse(mappingContext.getSource());
                }
            };
            this.modelMapper.addConverter(converter);

            Arrays.stream(this.gson.fromJson(Files.readString(Path
                            .of(RESOURCES_FILES_PATH + CUSTOMERS_NAME)), CustomerSeedDto[].class))
                    .map(customerSeedDto -> this.modelMapper.map(customerSeedDto, Customer.class))
                    .forEach(this.customerRepository::save);
        }
    }

    @Override
    public List<CustomerOrderedDto> getCustomerOrderedDtos() {
        Converter<LocalDateTime, String> converter = new Converter<LocalDateTime, String>() {
            @Override
            public String convert(MappingContext<LocalDateTime, String> mappingContext) {
                return mappingContext.getSource().toString();
            }
        };
        this.modelMapper.addConverter(converter);

        return this.customerRepository.findAllCustomerOrderedByBirthdate()
                .stream().map(customer -> this.modelMapper.map(customer, CustomerOrderedDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerTotalSalesDtos> getCustomerTotalSalesDtos() {
        Converter<Set<Sale>, Integer> converterCount = new Converter<Set<Sale>, Integer>() {
            @Override
            public Integer convert(MappingContext<Set<Sale>, Integer> mappingContext) {
                return mappingContext.getSource().size();
            }
        };

        Converter<Set<Sale>, BigDecimal> converterPrice = new Converter<Set<Sale>, BigDecimal>() {
            @Override
            public BigDecimal convert(MappingContext<Set<Sale>, BigDecimal> mappingContext) {
                return getSum(mappingContext.getSource());
            }
        };

        this.modelMapper.createTypeMap(Customer.class, CustomerTotalSalesDtos.class)
                .addMappings(mapping -> mapping.using(converterCount)
                        .map(Customer::getSales, CustomerTotalSalesDtos::setBoughtCars))
                .addMappings(mapping -> mapping.using(converterPrice)
                        .map(Customer::getSales, CustomerTotalSalesDtos::setSpentMoney));

        this.modelMapper.addMappings(new PropertyMap<Customer, CustomerTotalSalesDtos>() {
            @Override
            protected void configure() {
                map().setFullName(source.getName());
            }
        });

        return this.customerRepository.findAllBySalesIsNotNullOrderByTotalPriceThanCountSalesDesc()
                .stream().map(customer -> this.modelMapper.map(customer, CustomerTotalSalesDtos.class))
                .collect(Collectors.toList());
    }

   public static BigDecimal getSum(Set<Sale> sales) {
        BigDecimal sum = new BigDecimal(0);

        for (Sale sale : sales) {
            sum = sum.add(sale.getCar().getPrice());
        }

        return sum;
    }
}
