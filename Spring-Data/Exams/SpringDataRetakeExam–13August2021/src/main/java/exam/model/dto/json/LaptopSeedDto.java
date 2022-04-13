package exam.model.dto.json;

import com.google.gson.annotations.Expose;
import exam.model.dto.xml.TownNameXmlDto;
import exam.model.entity.enums.WarrantyType;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopSeedDto {

    @Expose
    @Size(min = 8)
    @NotNull
    private String macAddress;

    @Expose
    @Positive
    @NotNull
    private double cpuSpeed;

    @Expose
    @Min(8)
    @Max(128)
    @NotNull
    private int ram;

    @Expose
    @Min(128)
    @Max(1024)
    @NotNull
    private int storage;

    @Expose
    @Size(min = 10)
    @NotBlank
    private String description;

    @Expose
    @Positive
    @NotNull
    private BigDecimal price;

    @Expose
    @NotNull
    private WarrantyType warrantyType;

    @Expose
    @NotNull
    private ShopNameJsonDto shop;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ShopNameJsonDto getShop() {
        return shop;
    }

    public void setShop(ShopNameJsonDto shop) {
        this.shop = shop;
    }
}
