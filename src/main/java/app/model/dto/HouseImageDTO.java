package app.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseImageDTO {

    private Long id;

    private String imagePath;

    private String imageFilename;

    private String email;

}
