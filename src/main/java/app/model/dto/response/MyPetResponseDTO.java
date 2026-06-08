package app.model.dto.response;

import app.model.dto.MyPetItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPetResponseDTO {

    protected MyPetItemDTO pet;
    protected List<String> images;
}
