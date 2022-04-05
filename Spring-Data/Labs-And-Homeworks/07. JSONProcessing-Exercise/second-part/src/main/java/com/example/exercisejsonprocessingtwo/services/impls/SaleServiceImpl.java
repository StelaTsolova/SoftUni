package com.example.exercisejsonprocessingtwo.services.impls;

import com.example.exercisejsonprocessingtwo.models.dtos.CustomerTotalSalesDtos;
import com.example.exercisejsonprocessingtwo.models.dtos.SaleDiscountDto;
import com.example.exercisejsonprocessingtwo.models.entities.Customer;
import com.example.exercisejsonprocessingtwo.models.entities.Sale;
import com.example.exercisejsonprocessingtwo.repositories.CarRepository;
import com.example.exercisejsonprocessingtwo.repositories.CustomerRepository;
import com.example.exercisejsonprocessingtwo.repositories.SaleRepository;
import com.example.exercisejsonprocessingtwo.services.SaleService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.exercisejsonprocessingtwo.services.impls.CustomerServiceImpl.getSum;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository,
                           CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        if (this.saleRepository.count() == 0) {
            double[] discounts = new double[]{0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5};

            for (int i = 0; i < 40; i++) {
                Sale sale = new Sale();
                sale.setCar(this.carRepository.findById(ThreadLocalRandom
                                .current().nextLong(1, this.carRepository.count() + 1))
                        .orElse(null));
                sale.setCustomer(this.customerRepository.findById(ThreadLocalRandom
                                .current().nextLong(1, this.customerRepository.count() + 1))
                        .orElse(null));
                sale.setDiscount(discounts[ThreadLocalRandom.current()
                        .nextInt(0, discounts.length)]);

                this.saleRepository.save(sale);
            }
        }
    }

    @Override
    public Set<SaleDiscountDto> getSaleDiscountDtos() {
        Converter<Customer, BigDecimal> converter = new Converter<Customer, BigDecimal>() {
            @Override
            public BigDecimal convert(MappingContext<Customer, BigDecimal> mappingContext) {
                return getSum(mappingContext.getSource().getSales());
            }
        };
//
//        Converter<Map<Customer, BigDecimal>, BigDecimal> converterr = new Converter<Map<Customer, BigDecimal>, BigDecimal>() {
//            @Override
//            public BigDecimal convert(MappingContext<Map<Customer, BigDecimal>, BigDecimal> mappingContext) {
//                BigDecimal price = getSum(mappingContext.getSource().getCustomer().getSales());
//                BigDecimal discount = BigDecimal.valueOf(mappingContext.getSource().getDiscount());
//
//                return price.subtract(price.multiply(discount));
//            }
//        };



        this.modelMapper.createTypeMap(Sale.class, SaleDiscountDto.class)
                .addMappings(mapping -> mapping.using(converter)
                        .map(Sale::getCustomer, SaleDiscountDto::setPrice));
//                .addMappings(mapping -> mapping.using(converterr)
//                        .map(Map.of(Sale::getCustomer, Sale::getDiscount), SaleDiscountDto::setPriceWithDiscount);


//        this.modelMapper.addMappings(new PropertyMap<Sale, SaleDiscountDto>() {
//            @Override
//            protected void configure() {
////                using(converterr);
//                using(converter);
//                map().setPriceWithDiscount(getSum(source.getCustomer().getSales())
//                        .subtract(getSum(source.getCustomer().getSales())
//                                .multiply(BigDecimal.valueOf(source.getDiscount()))));
////                using(converterr).map(destination.setPriceWithDiscount());
//            }
//        });

       // this.modelMapper.getTypeMap(Sale.class, SaleDiscountDto.class);

//                .addMappings(mapping -> mapping.using(converterr)
//                        .map(Sale::getClass, SaleDiscountDto::setPrice));

//this.modelMapper.addConverter(converterr);
//        this.modelMapper.addMappings(new PropertyMap<Sale, SaleDiscountDto>() {
//            //            private BigDecimal price = source.getCar().getPrice();
//            @Override
//            protected void configure() {
//                map().setPriceWithDiscount(source.getCar().getPrice().subtract(source.getCar().getPrice()
//                        .multiply(BigDecimal.valueOf(source.getDiscount()))));
//            }
//        });

        return this.saleRepository.findAll()
                .stream().map(sale -> {
                    SaleDiscountDto saleDiscountDto = this.modelMapper.map(sale, SaleDiscountDto.class);
                    saleDiscountDto.setPriceWithDiscount(getPriceWhitDiscount(sale));

                    return saleDiscountDto;
                })
                .collect(Collectors.toSet());
    }

    private BigDecimal getPriceWhitDiscount(Sale source) {
        BigDecimal price = getSum(source.getCustomer().getSales());
        BigDecimal discount = BigDecimal.valueOf(source.getDiscount());

        return price.subtract(price.multiply(discount));
    }
}
