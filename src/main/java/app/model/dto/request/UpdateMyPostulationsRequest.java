package app.model.dto.request;

import app.model.enums.PostulationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMyPostulationsRequest {

    @NonNull
    private PostulationStatusEnum status;

}
