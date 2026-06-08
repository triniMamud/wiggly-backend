package app.model.dto.request;

import app.model.enums.TransitEnum;
import jakarta.persistence.Column;
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

    private String otherPetsInfo;

    @NonNull
    private String familyMembers;

    @NonNull
    private boolean hasChildren;

    private String childrenInfo;

    @NonNull
    private boolean costsAwareness;

    @NonNull
    private boolean canAffordTrainee;

    @NonNull
    private boolean canAffordWalker;

    @NonNull
    private String jobSituation;

    @NonNull
    private String timeAlonePet;

    @NonNull
    private String timesWalkPet;

    @NonNull
    private String sleepingPlace;

    @NonNull
    private boolean castrationCompromise;

    @NonNull
    private boolean followUp;

    @NonNull
    private String travelAsignee;

    @NonNull
    private CreateHouseTypeRequest houseTypeRequest;

    private String transitPreferences;

    private String maxTimeTransit;

    private String lastTransitsInfo;
}
