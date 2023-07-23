package app.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Set;

@Data
@Entity
@Table(name = "adoptant")
@NoArgsConstructor
public class Adoptant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private String userEmail;

    @OneToMany
    @JoinColumn(name = "adoptantPetId")
    private Set<Long> petIds;

}
