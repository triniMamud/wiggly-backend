package app.model.dto.request;

import app.model.enums.AgeEnum;
import app.model.enums.PetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetsSearchRequestParameters {
    private PetTypeEnum type;
    private AgeEnum ageEnum;
    private String gender;
    private String size;
}
