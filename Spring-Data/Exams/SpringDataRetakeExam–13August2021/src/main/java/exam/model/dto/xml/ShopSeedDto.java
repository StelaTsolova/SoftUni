package exam.model.dto.xml;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedDto {

    @XmlElement
    @Size(min = 4)
    @NotBlank
    private String address;

    @XmlElement (name = "employee-count")
    @Min(1)
    @Max(50)
    @NotNull
    private int employeeCount;

    @XmlElement
    @Min(20000)
    private BigDecimal income;

    @XmlElement (name = "name")
    @Size(min = 4)
    @NotBlank
    private String name;

    @XmlElement (name = "shop-area")
    @Min(150)
    @NotNull
    private int shopArea;

    @XmlElement
    @NotNull
    private TownNameXmlDto town;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public TownNameXmlDto getTown() {
        return town;
    }

    public void setTown(TownNameXmlDto town) {
        this.town = town;
    }
}
