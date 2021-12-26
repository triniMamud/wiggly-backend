package app.model.entity;

import app.model.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
