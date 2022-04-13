package exam.model.dto.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedRootDto {

    @XmlElement(name = "shop")
    private List<ShopSeedDto> shops;

    public List<ShopSeedDto> getShops() {
        return shops;
    }

    public void setShops(List<ShopSeedDto> shops) {
        this.shops = shops;
    }
}
