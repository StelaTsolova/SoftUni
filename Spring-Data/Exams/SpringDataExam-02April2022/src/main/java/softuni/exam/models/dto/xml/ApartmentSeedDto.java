package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.Town;
import softuni.exam.models.entity.enums.ApartmentType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentSeedDto {

    @XmlElement
    private String apartmentType;
    @XmlElement
    private double area;
    @XmlElement
    private String town;

    @NotNull
    public String getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Min(40)
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @NotNull
    @Size(min = 2)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
