package app.model.entity;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Perro extends Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perro_id")
    private int id;

    public Perro(MascotaDTO mascota) {
        super(mascota);
    }

}
