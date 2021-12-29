package app.model.entity;

import app.model.Adoptant;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class AdoptantDog extends Adoptant {
}
