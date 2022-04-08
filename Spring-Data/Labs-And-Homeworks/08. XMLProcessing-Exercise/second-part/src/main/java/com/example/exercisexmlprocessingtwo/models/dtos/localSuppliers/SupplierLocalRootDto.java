package com.example.exercisexmlprocessingtwo.models.dtos.localSuppliers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierLocalRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierLocalDto> suppliers;

    public List<SupplierLocalDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierLocalDto> suppliers) {
        this.suppliers = suppliers;
    }
}
