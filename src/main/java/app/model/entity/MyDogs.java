package app.model.entity;

import app.model.MyPets;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class MyDogs extends MyPets {

    public MyDogs(String username, int idDog) {
        super(username, idDog);
    }
}
