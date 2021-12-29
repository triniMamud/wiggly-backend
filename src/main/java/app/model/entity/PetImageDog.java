package app.model.entity;

import app.model.PetImage;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class PetImageDog extends PetImage {
}
