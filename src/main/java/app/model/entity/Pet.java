package app.model.entity;

import app.model.enums.BathroomEnum;
import app.model.enums.PetTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PetTypeEnum type;

    @Column(nullable = false)
    private float age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, name = "")
    private Boolean is_castrated;

    @Column(nullable = false)
    private String vaccines;

    @Column(nullable = false)
    private String deparasited;

    @Column(name = "illnesses_and_treatments", nullable = false)
    private String illnessesAndTreatments;

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
    @Enumerated(EnumType.ORDINAL)
    private BathroomEnum bathroomOutside;

    @Column(nullable = false, name = "pet_image_id")
    @ElementCollection
    private Set<Long> petImageIds;
}
