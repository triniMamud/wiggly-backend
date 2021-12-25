package app.model.dto;

import app.model.entity.Gato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatoDTO extends MascotaDTO {


    public GatoDTO(int id, String nombre, Float edadAprox, String sexo, String tamanio, String barrio, Boolean castrado, String vacunas, String aclaracionesVacunas, String desparacitado, String enfermedadesYTratamientos, String aclaracionesMedicas, String aclaracionesGenerales) {
        super();
    }
}
