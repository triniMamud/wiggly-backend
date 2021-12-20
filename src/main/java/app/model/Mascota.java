package app.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Mascota {
    private String nombre;
    private Float edadAprox;
    private String sexo;
    private Float peso;
    private String tamanio;
    private String barrio;
    private Boolean castrado;
    private String vacunas;
    private String aclaracionesVacunas;
    private String desparacitado;
    @Column(name = "enfermedades_y_tratamientos")
    private String enfermedadesYTratamientos;
    private String aclaracionesMedicas;
    private String aclaracionesGenerales;
}
