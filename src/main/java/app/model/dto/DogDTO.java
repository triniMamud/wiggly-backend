package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DogDTO extends PetDTO {

    public DogDTO(int id,
                  String name,
                  Float age,
                  String sex,
                  String size,
                  String neighbourhood,
                  Boolean castrated,
                  String vaccines,
                  String vaccinesInfo,
                  String deparasited,
                  String illnessesAndTreatments,
                  String medicalInfo,
                  String generalInfo) {
        super(id, name, age, sex, size, neighbourhood, castrated, vaccines, vaccinesInfo, deparasited, illnessesAndTreatments, medicalInfo, generalInfo);
    }
}
