package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    protected int id;
    protected String name;
    protected Float age;
    protected String sex;
    protected String size;
    protected String neighbourhood;
    protected Boolean castrated;
    protected String vaccines;
    protected String vaccinesInfo;
    protected String deparasited;
    protected String illnessesAndTreatments;
    protected String medicalInfo;
    protected String generalInfo;
}
