package app.model.dto.request;

import app.model.dto.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTORequest {

    protected PetDTO pet;
    protected List<String> images;
}
