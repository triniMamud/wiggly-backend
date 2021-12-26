package app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String usuario;
    private int gato;

    public FavouriteCat(String id_usuario, int id_gato) {
        this.usuario = id_usuario;
        this.gato = id_gato;
    }
}
