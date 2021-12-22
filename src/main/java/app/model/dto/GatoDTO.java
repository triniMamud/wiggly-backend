package app.model.dto;

import app.model.entity.Gato;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GatoDTO extends MascotaDTO {

    public GatoDTO(Gato gato) {
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
