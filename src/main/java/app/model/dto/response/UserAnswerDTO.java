package app.model.dto.response;

import app.model.enums.TransitEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswerDTO {

    private Long id;

    private String email;

    private boolean hasOtherPets;

    private String otherPetsInfo;

    private Integer familyMembers;

    private boolean hasChildren;

    private String childrenInfo;

    private boolean costsAwareness;

    private String jobSituation;

    private Float timeAlonePet;

    private Integer timesWalkPet;

    private String sleepingPlace;

    private boolean canAffordTrainee;

    private boolean canAffordWalker;

    private boolean castrationCompromise;

    private boolean followUp;

    private String travelAsignee;

    private TransitEnum transitPreferences;

    private String maxTimeTransit;

    private Long houseTypeId;

    private String lastTransitsInfo;
}
