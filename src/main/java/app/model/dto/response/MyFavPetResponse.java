package app.model.dto.response;

import app.model.dto.PetDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyFavPetResponse {

    protected Long idPet;
    protected String name;
    protected String gender;
    protected String location;
    protected float age;
    protected List<String> images;
    protected String shelterName;
}