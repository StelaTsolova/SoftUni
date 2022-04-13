package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.json.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMERS_FILE_NAME = "src/main/resources/files/json/customers.json";

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper,
                               TownService townService, CustomerRepository customerRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_NAME));
    }

    @Override
    public String importCustomers() throws IOException {
        List<String> massages = new ArrayList<>();
        Arrays.stream(this.gson.fromJson(readCustomersFileContent(), CustomerSeedDto[].class))
                .filter(customerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(customerSeedDto) && !isExistsByEmail(customerSeedDto.getEmail());
                    if (isValid) {
                        massages.add(String.format("Successfully imported Customer %s %s - %s",
                                customerSeedDto.getFirstName(), customerSeedDto.getLastName(), customerSeedDto.getEmail()));
                    } else {
                        massages.add("Invalid Customer");
                    }

                    return isValid;
                })
                .map(customerSeedDto -> {
                   Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);
                   customer.setTown(this.townService.getTownByName(customerSeedDto.getTown().getName()));

                   return customer;
                })
                .forEach(this.customerRepository::save);

        return String.join(System.lineSeparator(), massages);
    }

    private boolean isExistsByEmail(String email) {
        return this.customerRepository.existsByEmail(email);
    }
}
