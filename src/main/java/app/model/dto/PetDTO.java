package app.model.dto;

import app.model.entity.Pet;
import app.model.enums.BathroomEnum;
import app.model.enums.PetTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    @NotNull
    private float age;

    @NotBlank
    private String bathroomOutside;

    @NotNull
    private boolean beOnItsOwn;

    @NotBlank
    private String deparasited;

    @NotBlank
    private String gender;

    @NotBlank
    private String generalInfo;

    @NotBlank
    private String goodWithChildren;

    @NotBlank
    private String goodWithPets;

    @NotNull
    private Boolean isCastrated;

    @NotBlank
    private String location;

    @NotBlank
    private String medicalInfo;

    @NotBlank
    private String name;

    @NotBlank
    private String size;

    @NotBlank
    private String type;

    @NotBlank
    private String vaccines;
}
