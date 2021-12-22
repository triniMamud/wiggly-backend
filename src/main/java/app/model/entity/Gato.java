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
public class Gato extends Mascota {

    public Gato(MascotaDTO gato) {
        this.id = gato.getId();
        this.nombre = gato.getNombre();
        this.edadAprox = gato.getEdadAprox();
        this.sexo = gato.getSexo();
        this.peso = gato.getPeso();
        this.tamanio = gato.getTamanio();
        this.barrio = gato.getBarrio();
        this.castrado = gato.getCastrado();
        this.vacunas = gato.getVacunas();
        this.aclaracionesVacunas = gato.getAclaracionesVacunas();
        this.desparacitado = gato.getDesparacitado();
        this.enfermedadesYTratamientos = gato.getEnfermedadesYTratamientos();
        this.aclaracionesMedicas = gato.getAclaracionesMedicas();
        this.aclaracionesGenerales = gato.getAclaracionesGenerales();
    }
}
