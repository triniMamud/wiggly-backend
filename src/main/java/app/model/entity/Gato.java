package app.model.entity;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Gato extends Mascota {
    public Gato(int id, String nombre, Float edadAprox, String sexo, String tamanio, String barrio, Boolean castrado, String vacunas, String aclaracionesVacunas, String desparacitado, String enfermedadesYTratamientos, String aclaracionesMedicas, String aclaracionesGenerales) {
        super(id,nombre,edadAprox,sexo,tamanio,barrio,castrado,vacunas,aclaracionesVacunas,desparacitado,enfermedadesYTratamientos,aclaracionesMedicas,aclaracionesGenerales);
    }
}
