package app.model.dto;

import app.model.enums.AdoptionTypeEnum;
import app.model.enums.HouseTypeEnum;
import app.model.enums.OpenSpaceEnum;
import app.model.enums.TransitEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    private float timeAlonePet;
    private int timesWalkPet;
    private String sleepingPlace;
    private boolean canAffordTrainee;
    private boolean canAffordWalker;
    private boolean castrationCompromise;
    private boolean followUp;
    private String travelAsignee;
    private String transitPreferences;
    private String maxTimeTransit;
    private Long houseTypeId;
    private String lastTransitsInfo;
    private String houseType;
    private String openSpaces;
    private boolean hasContentionNet;
    private boolean isOwner;
    private boolean allowsPets;
    private List<byte[]> houseImages;
}
