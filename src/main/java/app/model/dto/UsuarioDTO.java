package app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String barrio;
    private String mailContacto;
    private long numeroContacto;

    private Boolean adopta;
    private String tipoDomicilio;
    private Boolean tienePatioOBalcon;
    private Boolean tieneRedContencion;
    private Boolean tieneOtrasMacotas;
    private String aclaracionOtrasMascotas;
    private String usuario;
}
