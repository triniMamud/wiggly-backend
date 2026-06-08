package app.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UpdateProfilePhotoRequestDTO {

    @NotBlank
    protected String profilePhoto;
}
