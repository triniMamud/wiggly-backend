package app.model.dto.request;

import app.model.enums.HouseTypeEnum;
import app.model.enums.OpenSpaceEnum;
import app.model.enums.TransitEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHouseTypeRequest {

    @NonNull
    private HouseTypeEnum type;

    @NonNull
    private OpenSpaceEnum openSpaces;

    @NonNull
    private boolean hasContentionNet;

    @NonNull
    private boolean isOwner;

    @NonNull
    private boolean allowsPets;

    @NotNull
    private List<CreateHouseImageRequest> houseImagesRequest;

}
