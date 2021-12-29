package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String name;
    private String lastName;
    private int age;
    private String neighbourhood;
    private String mail;
    private long phone;
    private Boolean adopts;
    private String houseType;
    private Boolean hasGardenOrBalcony;
    private Boolean hasContentionNet;
    private Boolean hasAnotherPets;
    private String otherPetsInfo;

}
