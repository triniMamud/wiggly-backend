package app.model.entity;

import app.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class Cat extends Pet {
    public Cat(int id,
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
