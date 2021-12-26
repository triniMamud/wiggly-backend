package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PerroDTO extends MascotaDTO {

    public PerroDTO(int id, String nombre, Float edadAprox, String sexo, String tamanio, String barrio, Boolean castrado, String vacunas, String aclaracionesVacunas, String desparacitado, String enfermedadesYTratamientos, String aclaracionesMedicas, String aclaracionesGenerales) {
        super(id,nombre,edadAprox,sexo,tamanio,barrio,castrado,vacunas,aclaracionesVacunas,desparacitado,enfermedadesYTratamientos,aclaracionesMedicas,aclaracionesGenerales);
    }
}
