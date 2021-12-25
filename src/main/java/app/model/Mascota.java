package app.model;

import app.model.dto.PerroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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
