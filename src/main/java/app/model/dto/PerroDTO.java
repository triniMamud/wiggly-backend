package app.model.dto;

import app.model.entity.Perro;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerroDTO extends MascotaDTO {

    public PerroDTO(Perro perro) {
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
