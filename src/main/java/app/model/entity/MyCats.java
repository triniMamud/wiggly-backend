package app.model.entity;

import app.model.MyPets;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class MyCats extends MyPets {

    public MyCats(String username, int idCat) {
        super(username, idCat);
    }
}
