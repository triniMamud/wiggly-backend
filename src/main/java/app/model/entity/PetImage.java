package app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "petimage")
public class PetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "image_path")
    private String imagePath;

    @Column(nullable = false, name = "image_filename")
    private String imageFilename;

    @Column(nullable = false, name = "pet_id")
    private Long petId;
}
