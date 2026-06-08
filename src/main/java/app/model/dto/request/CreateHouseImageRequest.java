package app.model.dto.request;

import app.model.enums.HouseTypeEnum;
import app.model.enums.OpenSpaceEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseImageRequest {

    @NotBlank
    private String imagePath;

    @NotBlank
    private String imageFilename;

}
