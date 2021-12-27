package app.model.entity;

import app.model.FavouritePet;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class FavouriteDog extends FavouritePet {

    public FavouriteDog(String id_usuario, int id_perro) {
        super(id_usuario,id_perro);
    }
}
