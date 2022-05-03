package softuni.exam.models.dto.xml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentNameDto {

    @XmlElement
    private String name;

    @Size(min = 2)
    @NotBlank

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
