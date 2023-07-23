package app.model.entity;

import app.model.enums.HouseTypeEnum;
import app.model.enums.OpenSpaceEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "housetype")
public class HouseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private HouseTypeEnum type;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OpenSpaceEnum openSpace;

    @Column(nullable = false)
    private boolean hasContentionNet;

    @Column(nullable = false)
    private boolean isOwner;

    @Column(nullable = false)
    private boolean allowsPet;

    @OneToMany
    @JoinColumn(name = "houseImageId", nullable = false)
    private Set<Long> houseImageIds;
}
