package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private Integer id;
    private String name;
    private Float age;
    private String sex;
    private String size;
    private String neighbourhood;
    private Boolean castrated;
    private String vaccines;
    private String vaccinesInfo;
    private String deparasited;
    private String illnessesAndTreatments;
    private String medicalInfo;
    private String generalInfo;
}
