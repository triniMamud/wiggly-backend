package app.model.dto;

import app.model.enums.AdoptionTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String lastName;
    private String email;
    private int age;
    private String dni;
    private long phone;
    private String location;
    private AdoptionTypeEnum adoptionType;
    private String shelterName;
}
