package com.example.exercisexmlprocessingtwo.models.dtos.carsFromMakeToyota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarToyotaRootDto {

    @XmlElement(name = "car")
    private List<CarToyotaDto> cars;

    public List<CarToyotaDto> getCars() {
        return cars;
    }

    public void setCars(List<CarToyotaDto> cars) {
        this.cars = cars;
    }
}
