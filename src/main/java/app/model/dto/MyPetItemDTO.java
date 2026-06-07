package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPetItemDTO {

    private int id;
    private String name;
    private String location;
    private String gender;
    private float age;
    private int favCount;
    private int postulationsCount;
}
