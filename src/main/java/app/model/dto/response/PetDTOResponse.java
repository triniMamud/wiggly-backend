package app.model.dto.response;

import app.model.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetDTOResponse {

    protected PetDTO pet;
    protected List<byte[]> images;

}