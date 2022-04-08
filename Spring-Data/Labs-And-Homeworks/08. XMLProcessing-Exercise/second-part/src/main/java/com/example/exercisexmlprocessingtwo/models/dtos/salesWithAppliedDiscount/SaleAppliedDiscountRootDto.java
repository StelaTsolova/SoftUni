package com.example.exercisexmlprocessingtwo.models.dtos.salesWithAppliedDiscount;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleAppliedDiscountRootDto {

    @XmlElement(name = "sale")
    private List<SaleAppliedDiscountDto> sales;

    public List<SaleAppliedDiscountDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleAppliedDiscountDto> sales) {
        this.sales = sales;
    }
}
