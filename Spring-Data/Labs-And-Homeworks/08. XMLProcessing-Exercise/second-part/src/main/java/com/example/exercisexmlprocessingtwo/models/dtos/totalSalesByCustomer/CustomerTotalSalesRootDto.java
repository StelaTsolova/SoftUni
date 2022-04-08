package com.example.exercisexmlprocessingtwo.models.dtos.totalSalesByCustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesRootDto {

    @XmlElement(name = "customer")
    private List<CustomerTotalSalesDto> customers;

    public List<CustomerTotalSalesDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerTotalSalesDto> customers) {
        this.customers = customers;
    }
}
