package com.example.exercisexmlprocessing.models.dtos.usersAndProducts;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserProductsRootDto {

    @XmlAttribute
    private long count;
    @XmlElement(name = "user")
    private List<UserProductsDto> users;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<UserProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserProductsDto> users) {
        this.users = users;
    }
}
