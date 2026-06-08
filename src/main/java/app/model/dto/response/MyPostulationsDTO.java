package app.model.dto.response;

import app.model.enums.PostulationStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPostulationsDTO {

    private Long id;
    private String email;
    private Long petId;
    private PostulationStatusEnum status;
    private LocalDateTime sentAt;
    private LocalDateTime receivedAt;
    private LocalDateTime reviewedAt;
}
