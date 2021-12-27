package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "enfermedades_y_tratamientos")
    protected String enfermedadesYTratamientos;
    protected String aclaracionesMedicas;
    protected String aclaracionesGenerales;
}
