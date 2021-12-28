package app.model.entity;

import app.model.FavouritePet;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class FavouriteCat extends FavouritePet {

    public FavouriteCat(String id_usuario, int id_gato) {
        super(id_usuario,id_gato);
    }
}
