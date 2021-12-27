package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class FavouritePet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String usuario;
    private int id_mascota;

    public FavouritePet(String id_usuario, int id_mascota) {
        this.usuario = id_usuario;
        this.id_mascota = id_mascota;
    }

}
