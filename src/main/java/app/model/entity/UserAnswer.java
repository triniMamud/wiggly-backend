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
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "has_other_pets")
    private boolean hasOtherPets;

    @Column(name = "other_pets_info")
    private String otherPetsInfo;

    @Column(nullable = false, name = "family_members")
    private Integer familyMembers;

    @Column(nullable = false, name = "has_children")
    private boolean hasChildren;

    @Column(name = "children_info")
    private String childrenInfo;

    @Column(nullable = false, name = "costs_awareness")
    private boolean costsAwareness;

    @Column(nullable = false, name = "job_situation")
    private String jobSituation;

    @Column(nullable = false, name = "time_alone_pet")
    private String timeAlonePet;

    @Column(nullable = false, name = "times_walk_pet")
    private String timesWalkPet;

    @Column(nullable = false, name = "sleeping_place")
    private String sleepingPlace;

    @Column(nullable = false, name = "can_afford_trainee")
    private boolean canAffordTrainee;

    @Column(nullable = false, name = "can_afford_walker")
    private boolean canAffordWalker;

    @Column(nullable = false, name = "castration_compromise")
    private boolean castrationCompromise;

    @Column(nullable = false, name = "follow_up")
    private boolean followUp;

    @Column(nullable = false, name = "travel_asignee")
    private String travelAsignee;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transit_preferences")
    private TransitEnum transitPreferences;

    @Column(name = "max_time_transit")
    private String maxTimeTransit;

    @Column(nullable = false, name = "house_type_id")
    private Long houseTypeId;

    @Column(name = "last_transits_info")
    private String lastTransitsInfo;
}
