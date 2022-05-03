package softuni.exam.models.dto.xml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    @XmlElement
    private BigDecimal price;
    @XmlElement
    private AgentNameDto agent;
    @XmlElement
    private ApartmentIdDto apartment;
    @XmlElement
    private String publishedOn;

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public AgentNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentNameDto agent) {
        this.agent = agent;
    }

    @NotNull
    public ApartmentIdDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDto apartment) {
        this.apartment = apartment;
    }

    @NotBlank
    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
