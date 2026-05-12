package app.model.dto.response;

import app.model.dto.ItemDTO;
import app.model.enums.PostulationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class PetAdoptionResponseDTO {

    protected ItemDTO pet;
    private PostulationStatusEnum status;
    private List<String> petImages;
}
