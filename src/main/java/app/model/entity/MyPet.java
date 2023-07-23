package app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@Table(name = "mypet")
@Entity
@NoArgsConstructor
public class MyPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private String userEmail;

    @OneToMany
    @JoinColumn(name = "myPetId", nullable = false)
    private Set<Long> petIds;

}
