package app.model.entity;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gato extends Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gato_id")
    private int id;

    public Gato(MascotaDTO mascota) {
        super(mascota);
    }
}
