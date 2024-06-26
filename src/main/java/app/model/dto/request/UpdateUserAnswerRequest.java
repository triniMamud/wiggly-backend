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
public class UpdateUserAnswerRequest {

    private boolean hasOtherPets;

    private String otherPetsInfo;

    private Integer familyMembers;

    private boolean hasChildren;

    private String childrenInfo;

    private boolean costsAwareness;

    private String jobSituation;

    private String timeAlonePet;

    private Integer timesWalkPet;

    private String sleepingPlace;

    private boolean canAffordTrainee;

    private boolean canAffordWalker;

    private boolean castrationCompromise;

    private boolean followUp;

    private String travelAsignee;

    private TransitEnum transitPreferences;

    private String maxTimeTransit;

    private String lastTransitsInfo;

}
