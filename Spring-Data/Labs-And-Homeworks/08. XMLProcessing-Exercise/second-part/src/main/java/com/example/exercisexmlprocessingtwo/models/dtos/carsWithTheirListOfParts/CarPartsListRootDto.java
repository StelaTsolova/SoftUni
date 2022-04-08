package com.example.exercisexmlprocessingtwo.models.dtos.carsWithTheirListOfParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsListRootDto {

    @XmlElement(name = "car")
    private List<CarPartsListDto> parts;

    public List<CarPartsListDto> getParts() {
        return parts;
    }

    public void setParts(List<CarPartsListDto> parts) {
        this.parts = parts;
    }
}
