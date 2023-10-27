package app.model.entity;

import app.model.enums.HouseTypeEnum;
import app.model.enums.OpenSpaceEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "housetype")
@Data
public class HouseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private HouseTypeEnum type;

    @Column(nullable = false, name = "open_spaces")
    @Enumerated(EnumType.ORDINAL)
    private OpenSpaceEnum openSpaces;

    @Column(nullable = false, name = "has_contention_net")
    private boolean hasContentionNet;

    @Column(nullable = false, name = "is_owner")
    private boolean isOwner;

    @Column(nullable = false, name = "allows_pets")
    private boolean allowsPets;

    @Column(name = "house_image_id")
    @ElementCollection
    private Set<Long> houseImageIds;

    @Column(nullable = false)
    private String email;

}
