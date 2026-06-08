package app.model.entity;

import app.model.enums.AdoptionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "birth_date")
    private LocalDate birthDate;

    @Column(nullable = false)
    private long phone;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name = "adoption_type")
    private AdoptionTypeEnum adoptionType;

    @Lob
    @Column(name = "profile_photo", columnDefinition = "LONGTEXT")
    private String profilePhoto;

    @Column(name = "form_answered", nullable = false)
    private Boolean isFormAnswered;

    @Column(name = "shelter_name")
    private String shelterName;
}
