package com.example.exercisexmlprocessingtwo.services.impls;

import com.example.exercisexmlprocessingtwo.models.dtos.salesWithAppliedDiscount.SaleAppliedDiscountDto;
import com.example.exercisexmlprocessingtwo.models.dtos.salesWithAppliedDiscount.SaleAppliedDiscountRootDto;
import com.example.exercisexmlprocessingtwo.models.entities.Sale;
import com.example.exercisexmlprocessingtwo.repositories.CarRepository;
import com.example.exercisexmlprocessingtwo.repositories.CustomerRepository;
import com.example.exercisexmlprocessingtwo.repositories.SaleRepository;
import com.example.exercisexmlprocessingtwo.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.exercisexmlprocessingtwo.services.impls.CustomerServiceImpl.getSum;

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
    public long getEntityCount() {
        return this.saleRepository.count();
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
    public SaleAppliedDiscountRootDto getSaleAppliedDiscountRootDto() {
        SaleAppliedDiscountRootDto rootDto = new SaleAppliedDiscountRootDto();

        rootDto.setSales(this.saleRepository.findAll().stream()
                .map(sale -> {
                    SaleAppliedDiscountDto dto = this.modelMapper.map(sale, SaleAppliedDiscountDto.class);
                    dto.setPrice(getSum(sale.getCustomer().getSales()));
                    dto.setPriceWithDiscount(getPriceWhitDiscount(sale));

                    return dto;
                })
                .collect(Collectors.toList()));

        return rootDto;
    }

    private BigDecimal getPriceWhitDiscount(Sale source) {
        BigDecimal price = getSum(source.getCustomer().getSales());
        BigDecimal discount = BigDecimal.valueOf(source.getDiscount());

        return price.subtract(price.multiply(discount));
    }
}
