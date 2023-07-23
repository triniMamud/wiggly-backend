package app.model.entity;

import app.model.enums.TransitEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "useranswers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private boolean hasOtherPets;

    @Column(nullable = false)
    private String otherPetsInfo;

    @Column(nullable = false)
    private int familyMembers;

    @Column(nullable = false)
    private boolean hasChildren;

    @Column(nullable = false)
    private String childrenInfo;

    @Column(nullable = false)
    private boolean costsAwareness;

    @Column(nullable = false)
    private String jobSituation;

    @Column(nullable = false)
    private float timeAlonePet;

    @Column(nullable = false)
    private int timesWalkPet;

    @Column(nullable = false)
    private String sleepingPlace;

    @Column(nullable = false)
    private boolean canAffordTrainee;

    @Column(nullable = false)
    private boolean canAffordWalker;

    @Column(nullable = false)
    private boolean castrationCompromise;

    @Column(nullable = false)
    private boolean followUp;

    @Column(nullable = false)
    private String travelAsignee;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TransitEnum transitPreferences;

    @Column(nullable = false)
    private String maxTimeTransit;

    @OneToOne
    @JoinColumn(name = "houseTypeId", nullable = false)
    private Long houseTypeId;

    @Column(nullable = false)
    private String lastTransitsInfo;
}
