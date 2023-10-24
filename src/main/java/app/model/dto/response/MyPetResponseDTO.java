package app.model.dto.response;

import app.model.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPetResponseDTO {

    protected ItemDTO pet;
    protected List<byte[]> images;
}
