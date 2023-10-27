package app.model.dto.request;

import app.model.enums.BathroomEnum;
import app.model.enums.PetTypeEnum;
import app.model.enums.TransitEnum;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePetRequest {

    private String name;

    private PetTypeEnum type;

    private Float age;

    private String gender;

    private String size;

    private String location;

    private Boolean isCastrated;

    private String vaccines;

    private String deparasited;

    private String medicalInfo;

    private String generalInfo;

    private String goodWithPets;

    private String goodWithChildren;

    private Boolean beOnItsOwn;

    private BathroomEnum bathroomOutside;

    @Builder.Default
    private List<String> images = new ArrayList<>();

}
