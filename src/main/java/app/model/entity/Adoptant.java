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
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "pet_id")
    @ElementCollection
    private Set<Long> petIds;

}
