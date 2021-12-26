package app.model.entity;

import app.model.Mascota;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Perro extends Mascota {
    public Perro(int id, String nombre, Float edadAprox, String sexo, String tamanio, String barrio, Boolean castrado, String vacunas, String aclaracionesVacunas, String desparacitado, String enfermedadesYTratamientos, String aclaracionesMedicas, String aclaracionesGenerales) {
        super(id,nombre,edadAprox,sexo,tamanio,barrio,castrado,vacunas,aclaracionesVacunas,desparacitado,enfermedadesYTratamientos,aclaracionesMedicas,aclaracionesGenerales);
    }
}
