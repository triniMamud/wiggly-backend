package app.model.dto.request;

import app.model.enums.TransitEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserAnswerRequest {

    @NonNull
    private boolean hasOtherPets;

    @NotBlank
    private String otherPetsInfo;

    @NonNull
    private Integer familyMembers;

    @NonNull
    private boolean hasChildren;

    @NotBlank
    private String childrenInfo;

    @NonNull
    private boolean costsAwareness;

    @NotBlank
    private String jobSituation;

    @NonNull
    private Float timeAlonePet;

    @NonNull
    private Integer timesWalkPet;

    @NotBlank
    private String sleepingPlace;

    @NonNull
    private boolean canAffordTrainee;

    @NonNull
    private boolean canAffordWalker;

    @NonNull
    private boolean castrationCompromise;

    @NonNull
    private boolean followUp;

    @NonNull
    private String travelAsignee;

    @NonNull
    private TransitEnum transitPreferences;

    @NotBlank
    private String maxTimeTransit;

    @NonNull
    private Long houseTypeId;

    @NotBlank
    private String lastTransitsInfo;

    @NonNull
    private CreateHouseTypeRequest houseTypeRequest;

}
