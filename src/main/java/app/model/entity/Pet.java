package app.model.entity;

import app.model.enums.AgeEnum;
import app.model.enums.BathroomEnum;
import app.model.enums.PetTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.EnumType.ORDINAL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(ORDINAL)
    private PetTypeEnum type;

    @Column(nullable = false)
    private float age;

    private AgeEnum ageEnum;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, name = "is_castrated")
    private Boolean isCastrated;

    @Column(nullable = false)
    private String vaccines;

    @Column(nullable = false)
    private String deparasited;

    @Column(nullable = false, name = "medical_info")
    private String medicalInfo;

    @Column(nullable = false, name = "general_info")
    private String generalInfo;

    @Column(nullable = false, name = "good_with_pets")
    private String goodWithPets;

    @Column(nullable = false, name = "good_with_children")
    private String goodWithChildren;

    @Column(nullable = false, name = "be_on_its_own")
    private boolean beOnItsOwn;

    @Column(nullable = false, name = "bathroom_outside")
    @Enumerated(ORDINAL)
    private BathroomEnum bathroomOutside;

    @Column(nullable = false, name = "pet_image_id")
    @ElementCollection
    private Set<Long> petImageIds = new HashSet<>();

    @Column(nullable = false, name = "is_fav_pet")
    private Boolean isFavPet;
}
