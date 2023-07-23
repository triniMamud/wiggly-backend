package app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "favouritepet")
public class FavouritePet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private String userEmail;

    @OneToMany
    @JoinColumn(name = "favouritePetId", nullable = false)
    @Builder.Default
    private Set<Long> petIds = new HashSet<>();
}
