package app.model.dto.response;

import app.model.enums.AdoptionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloackUserResponse {

    private String name;
    private String email;
    private boolean formAnswered;
    private AdoptionTypeEnum adoptionType;
}
