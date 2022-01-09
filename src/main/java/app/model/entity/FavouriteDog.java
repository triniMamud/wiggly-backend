package app.model.entity;

import app.model.FavouritePet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class FavouriteDog extends FavouritePet {

    public FavouriteDog(String username, int idDog) {
        super(username, idDog);
    }

}
