package app.model.entity;

import app.model.enums.AdoptionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private long phone;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private AdoptionTypeEnum adoptionType;

    @OneToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Long accountId;
}
