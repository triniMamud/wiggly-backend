package app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String usuario;
    private int perro;

    public FavouriteDog(String id_usuario, int id_perro) {
        this.usuario = id_usuario;
        this.perro = id_perro;
    }
}
