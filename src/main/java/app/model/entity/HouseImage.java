package app.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "houseimage")
@Data
public class HouseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "image_path")
    private String imagePath;

    @Column(nullable = false, name = "image_filename")
    private String imageFilename;

    @Column(nullable = false, name = "email")
    private String email;
}
