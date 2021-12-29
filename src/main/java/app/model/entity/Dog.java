package app.model.entity;

import app.model.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Dog extends Pet {
    public Dog(int id,
               String name,
               Float age,
               String sex,
               String size,
               String neighbourhood,
               Boolean castrated,
               String vaccines,
               String vaccinesInfo,
               String dewormed,
               String illnessesAndTreatments,
               String medicalInfo,
               String generalInfo) {
        super(id, name, age, sex, size, neighbourhood, castrated, vaccines, vaccinesInfo, dewormed, illnessesAndTreatments, medicalInfo, generalInfo);
    }
}
