package com.example.exercisexmlprocessingtwo;

import com.example.exercisexmlprocessingtwo.models.dtos.salesWithAppliedDiscount.SaleAppliedDiscountRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.totalSalesByCustomer.CustomerTotalSalesRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.carsWithTheirListOfParts.CarPartsListRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.localSuppliers.SupplierLocalRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota.CarToyotaRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.orderedCustomers.CustomerOrderedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CustomerSeedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.CarSeedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.PartSeedRootDto;
import com.example.exercisexmlprocessingtwo.models.dtos.seed.SupplierSeedRootDto;
import com.example.exercisexmlprocessingtwo.services.*;
import com.example.exercisexmlprocessingtwo.utils.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCES_FILES_PATH = "src/main/resources/";
    private static final String SUPPLIERS_FILE_NAME = "files/suppliers.xml";
    private static final String PARTS_FILE_NAME = "files/parts.xml";
    private static final String CARS_FILE_NAME = "files/cars.xml";
    private static final String CUSTOMERS_FILE_NAME = "files/customers.xml";

    private static final String ORDERED_CUSTOMERS_NAME = "outputs/ordered-customers.xml";
    private static final String TOYOTA_CARS_NAME = "outputs/toyota-cars.xml";
    private static final String LOCAL_SUPPLIERS_NAME = "outputs/local-suppliers.xml";
    private static final String CARS_AND_PARTS_NAME = "outputs/cars-and-parts.xml";
    private static final String CUSTOMERS_TOTAL_SALES_NAME = "outputs/customers-total-sales.xml";
    private static final String SALES_DISCOUNTS_NAME = "outputs/sales-discounts.xml";

    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    public CommandLineRunnerImpl(XmlParser xmlParser, SupplierService supplierService,
                                 PartService partService, CarService carService,
                                 CustomerService customerService, SaleService saleService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        // 4. Car Dealer Query and Export Data

        // orderedCustomers();

        //  carsFromMakeToyota();

        // localSuppliers();

        // carsWithTheirListOfParts();

        // totalSalesByCustomer();

        // salesWithAppliedDiscount();
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (this.supplierService.getEntityCount() == 0) {
            SupplierSeedRootDto supplierSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILES_PATH + SUPPLIERS_FILE_NAME, SupplierSeedRootDto.class);

            this.supplierService.seedSuppliers(supplierSeedRootDto.getSuppliers());
        }

        if (this.partService.getEntityCount() == 0) {
            PartSeedRootDto partSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILES_PATH + PARTS_FILE_NAME, PartSeedRootDto.class);

            this.partService.seedParts(partSeedRootDto.getParts());
        }

        if (this.carService.getEntityCount() == 0) {
            CarSeedRootDto carSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILES_PATH + CARS_FILE_NAME, CarSeedRootDto.class);

            this.carService.seedCars(carSeedRootDto.getCars());
        }

        if (this.customerService.getEntityCount() == 0) {
            CustomerSeedRootDto customerSeedRootDto = this.xmlParser
                    .fromXml(RESOURCES_FILES_PATH + CUSTOMERS_FILE_NAME, CustomerSeedRootDto.class);

            this.customerService.seedCustomers(customerSeedRootDto.getCustomers());
        }

        if (this.saleService.getEntityCount() == 0) {
            this.saleService.seedSales();
        }
    }

    private void orderedCustomers() throws JAXBException {
        CustomerOrderedRootDto customerOrderedRootDto = this.customerService.getCustomerOrderedRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + ORDERED_CUSTOMERS_NAME, customerOrderedRootDto);
    }

    private void carsFromMakeToyota() throws JAXBException {
        CarToyotaRootDto carToyotaRootDto = this.carService.getCarToyotaRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + TOYOTA_CARS_NAME, carToyotaRootDto);
    }

    private void localSuppliers() throws JAXBException {
        SupplierLocalRootDto supplierLocalRootDto = this.supplierService.getSupplierLocalRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + LOCAL_SUPPLIERS_NAME, supplierLocalRootDto);
    }

    private void carsWithTheirListOfParts() throws JAXBException {
        CarPartsListRootDto carPartsListRootDto = this.carService.getCarPartsListRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + CARS_AND_PARTS_NAME, carPartsListRootDto);
    }

    private void totalSalesByCustomer() throws JAXBException {
        CustomerTotalSalesRootDto customerTotalSalesRootDto = this.customerService.getCustomerTotalSalesRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + CUSTOMERS_TOTAL_SALES_NAME, customerTotalSalesRootDto);
    }

    private void salesWithAppliedDiscount() throws JAXBException {
        SaleAppliedDiscountRootDto saleAppliedDiscountRootDto = this.saleService.getSaleAppliedDiscountRootDto();

        this.xmlParser.toXml(RESOURCES_FILES_PATH + SALES_DISCOUNTS_NAME, saleAppliedDiscountRootDto);
    }
}
