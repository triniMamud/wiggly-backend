package app.model;

import app.model.dto.MascotaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
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

    public Mascota(MascotaDTO mascota) {
        this.setNombre(mascota.getNombre());
        this.setEdadAprox(mascota.getEdadAprox());
        this.setSexo(mascota.getSexo());
        this.setPeso(mascota.getPeso());
        this.setTamanio(mascota.getTamanio());
        this.setBarrio(mascota.getBarrio());
        this.setCastrado(mascota.getCastrado());
        this.setVacunas(mascota.getVacunas());
        this.setAclaracionesVacunas(mascota.getAclaracionesVacunas());
        this.setDesparacitado(mascota.getDesparacitado());
        this.setEnfermedadesYTratamientos(mascota.getEnfermedadesYTratamientos());
        this.setAclaracionesMedicas(mascota.getAclaracionesMedicas());
        this.setAclaracionesGenerales(mascota.getAclaracionesGenerales());
    }
}
