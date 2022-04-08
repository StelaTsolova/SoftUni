package com.example.exercisexmlprocessing.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "categories")
public class Category {

    private Long id;
    private String name;
    private Set<Product> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Transient
    public BigDecimal getAverageProductsPriceSum() {
        return getTotalProductsPriceSum()
                .divide(BigDecimal.valueOf(this.products.size()), 6, RoundingMode.HALF_UP);
    }

    @Transient
    public BigDecimal getTotalProductsPriceSum() {
        List<BigDecimal> prices = this.products.stream().map(Product::getPrice)
                .collect(Collectors.toList());

        BigDecimal totalSum = new BigDecimal(0);
        for (BigDecimal g : prices) {
            totalSum = totalSum.add(g);
        }

        return totalSum;
    }
}
