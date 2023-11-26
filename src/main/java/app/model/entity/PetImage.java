package app.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "petimage")
public class PetImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false, name = "image_path", columnDefinition = "LONGTEXT")
    private String imagePath;

    @Lob
    @Column(nullable = false, name = "image_filename", columnDefinition = "LONGTEXT")
    private String imageFilename;

    @Column(nullable = false, name = "pet_id")
    private Long petId;
}
