package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDTO {

    private int id;
    private String name;
    private String neighborhood;
    private String sex;
    //private String photo
}
