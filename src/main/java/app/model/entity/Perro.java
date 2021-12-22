package app.model.entity;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Perro extends Mascota {

    public Perro(MascotaDTO perro) {
        this.id = perro.getId();
        this.nombre = perro.getNombre();
        this.edadAprox = perro.getEdadAprox();
        this.sexo = perro.getSexo();
        this.peso = perro.getPeso();
        this.tamanio = perro.getTamanio();
        this.barrio = perro.getBarrio();
        this.castrado = perro.getCastrado();
        this.vacunas = perro.getVacunas();
        this.aclaracionesVacunas = perro.getAclaracionesVacunas();
        this.desparacitado = perro.getDesparacitado();
        this.enfermedadesYTratamientos = perro.getEnfermedadesYTratamientos();
        this.aclaracionesMedicas = perro.getAclaracionesMedicas();
        this.aclaracionesGenerales = perro.getAclaracionesGenerales();
    }

}
