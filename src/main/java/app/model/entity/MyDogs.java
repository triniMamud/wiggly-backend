package app.model.entity;

import app.model.MyPets;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class MyDogs extends MyPets {

    public MyDogs(String username, int idDog) {
        super(username, idDog);
    }
}
