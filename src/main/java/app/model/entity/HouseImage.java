package app.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "houseimage")
public class HouseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "image_path")
    private String imagePath;

    @Column(nullable = false, name = "image_filename")
    private String imageFilename;
}
