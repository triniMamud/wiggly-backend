package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GatoDTO extends MascotaDTO {


    public GatoDTO(int id, String nombre, Float edadAprox, String sexo, String tamanio, String barrio, Boolean castrado, String vacunas, String aclaracionesVacunas, String desparacitado, String enfermedadesYTratamientos, String aclaracionesMedicas, String aclaracionesGenerales) {
        super();
    }
}
