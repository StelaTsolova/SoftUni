package com.example.exercisejsonprocessingtwo.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {

    private Long id;
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<Part> parts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @Transient
    public BigDecimal getPrice(){
        BigDecimal totalPrice = new BigDecimal(0);

        for (Part part: this.parts){
            totalPrice = totalPrice.add(part.getPrice());
        }

        return totalPrice;
    }
}
