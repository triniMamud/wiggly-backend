package app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
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
    private int accountId;
}
