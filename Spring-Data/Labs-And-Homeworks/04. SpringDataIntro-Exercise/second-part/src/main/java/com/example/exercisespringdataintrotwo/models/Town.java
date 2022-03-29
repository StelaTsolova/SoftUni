package com.example.exercisespringdataintrotwo.models;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town {

    private Integer id;
    private String name;
    private String country;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
