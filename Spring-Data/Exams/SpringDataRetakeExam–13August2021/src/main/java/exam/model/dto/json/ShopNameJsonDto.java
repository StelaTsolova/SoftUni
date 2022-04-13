package exam.model.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class ShopNameJsonDto {

    @Expose
    @Size(min = 4)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
