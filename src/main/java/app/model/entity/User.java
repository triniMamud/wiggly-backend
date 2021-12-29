package app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String usuario;
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

}
