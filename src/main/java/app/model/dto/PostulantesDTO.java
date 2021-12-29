package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostulantesDTO {

    private String name;
    private String lastName;
    private String neighbourhood;
    private String houseType;

    //private String photo;
}
