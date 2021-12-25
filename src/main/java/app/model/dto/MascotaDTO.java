package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
    protected int id;
    protected String nombre;
    protected Float edadAprox;
    protected String sexo;
    protected String tamanio;
    protected String barrio;
    protected Boolean castrado;
    protected String vacunas;
    protected String aclaracionesVacunas;
    protected String desparacitado;
    protected String enfermedadesYTratamientos;
    protected String aclaracionesMedicas;
    protected String aclaracionesGenerales;
}
