package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullDTO extends UserDTO {

    private String dni;
    private String lastName;
    private int age;
    private long phone;
    private String location;
    private String adoptionType;
    private boolean hasOtherPets;
    private String otherPetsInfo;
    private int familyMembers;
    private boolean hasChildren;
    private String childrenInfo;
    private boolean costsAwareness;
    private String jobSituation;
    private String timeAlonePet;
    private String timesWalkPet;
    private String sleepingPlace;
    private boolean canAffordTrainee;
    private boolean canAffordWalker;
    private boolean castrationCompromise;
    private boolean followUp;
    private String travelAsignee;
    private String transitPreferences;
    private String maxTimeTransit;
    private String lastTransitsInfo;
    private HouseTypeDTO house;
}
