package app.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "houseimage")
public class HouseImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private String imageFilename;
}
