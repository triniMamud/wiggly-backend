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
    private PetTypeEnum petType;

    @Column(nullable = false)
    private float age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Boolean isCastrated;

    @Column(nullable = false)
    private String vaccines;

    @Column(nullable = false)
    private String deparasited;

    @Column(name = "illnesses_and_treatments", nullable = false)
    private String illnessesAndTreatments;

    @Column(nullable = false)
    private String medicalInfo;

    @Column(nullable = false)
    private String generalInfo;

    @Column(nullable = false)
    private String goodWithPets;

    @Column(nullable = false)
    private String goodWithChildren;

    @Column(nullable = false)
    private boolean beOnItsOwn;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private BathroomEnum bathroomOutside;

    @OneToMany
    @JoinColumn(name = "petImageId", nullable = false)
    private Set<Long> petImageIds;
}
