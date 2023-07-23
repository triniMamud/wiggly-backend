package app.model.entity;

import app.model.enums.PostulationStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "mypostulations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyPostulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private String userEmail;

    @OneToMany
    @JoinColumn(name = "myPostulationPetId", nullable = false)
    private Set<Long> petIds;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PostulationStatusEnum status;
}
