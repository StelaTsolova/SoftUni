package com.example.exercisejsonprocessingtwo;

import com.example.exercisejsonprocessingtwo.models.dtos.*;
import com.example.exercisejsonprocessingtwo.services.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCES_OUTPUTS_PATH = "src/main/resources/outputs/";
    private static final String ORDERED_CUSTOMERS_NAME = "ordered-customers.json";
    private static final String TOYOTA_CARS_NAME = "toyota-cars.json";
    private static final String LOCAL_SUPPLIERS_NAME = "local-suppliers.json";
    private static final String CARS_AND_PARTS_NAME = "cars-and-parts.json";
    private static final String CUSTOMERS_TOTAL_SALES_NAME = "customers-total-sales.json";
    private static final String SALES_DISCOUNTS_NAME = "sales-discounts.json";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;

    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService,
                                 CarService carService, CustomerService customerService,
                                 SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        //  seedDate();

        // 6. Car Dealer Query and Export Data
        // orderedCustomers();

        // carsFromMakeToyota();

        // localSuppliers();

        // carsWithTheirListOfParts();

        // totalSalesByCustomer();

        salesWithAppliedDiscount();

    }

    private void seedDate() throws IOException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
    }

    private void orderedCustomers() throws IOException {
        List<CustomerOrderedDto> customerOrderedDtos = this.customerService
                .getCustomerOrderedDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + ORDERED_CUSTOMERS_NAME),
                Collections.singleton(this.gson.toJson(customerOrderedDtos)));
    }

    private void carsFromMakeToyota() throws IOException {
        List<CarToyotaDto> carToyotaDtos = this.carService.getCarToyotaDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + TOYOTA_CARS_NAME),
                Collections.singletonList(this.gson.toJson(carToyotaDtos)));
    }

    private void localSuppliers() throws IOException {
        List<SupplierLocalDto> supplierLocalDtos = this.supplierService.getSupplierLocalDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + LOCAL_SUPPLIERS_NAME),
                Collections.singleton(this.gson.toJson(supplierLocalDtos)));
    }

    private void carsWithTheirListOfParts() throws IOException {
        List<CarListPartsDto> carListPartsDtos = this.carService.getCarListPartsDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + CARS_AND_PARTS_NAME),
                Collections.singleton(this.gson.toJson(carListPartsDtos)));
    }

    private void totalSalesByCustomer() throws IOException {
        List<CustomerTotalSalesDtos> customerTotalSalesDtos = this.customerService.getCustomerTotalSalesDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + CUSTOMERS_TOTAL_SALES_NAME),
                Collections.singleton(this.gson.toJson(customerTotalSalesDtos)));
    }

    private void salesWithAppliedDiscount() throws IOException {
        Set<SaleDiscountDto> saleDiscountDtos = this.saleService.getSaleDiscountDtos();

        Files.write(Path.of(RESOURCES_OUTPUTS_PATH + SALES_DISCOUNTS_NAME),
                Collections.singleton(this.gson.toJson(saleDiscountDtos)));
    }
}
