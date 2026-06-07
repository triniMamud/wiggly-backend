package app.model.entity;

import app.model.enums.PostulationStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "mypostulations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyPostulations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "pet_id")
    private Long petId;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PostulationStatusEnum status;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @Column(name = "received_at")
    private LocalDateTime receivedAt;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt;
}
