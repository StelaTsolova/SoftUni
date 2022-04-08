package com.example.exercisexmlprocessing.models.dtos.usersAndProducts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsCountDto {

    @XmlAttribute
    private long count;
    @XmlElement(name = "product")
    private List<ProductDto> products;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
