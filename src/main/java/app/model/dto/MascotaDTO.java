package app.model.dto;

import app.model.Mascota;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MascotaDTO {
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
    private String enfermedadesYTratamientos;
    private String aclaracionesMedicas;
    private String aclaracionesGenerales;

    public MascotaDTO(Mascota mascota) {
        this.nombre = mascota.getNombre();
        this.edadAprox = mascota.getEdadAprox();
        this.sexo = mascota.getSexo();
        this.peso = mascota.getPeso();
        this.tamanio = mascota.getTamanio();
        this.barrio = mascota.getBarrio();
        this.castrado = mascota.getCastrado();
        this.vacunas = mascota.getVacunas();
        this.aclaracionesVacunas = mascota.getAclaracionesVacunas();
        this.desparacitado = mascota.getDesparacitado();
        this.enfermedadesYTratamientos = mascota.getEnfermedadesYTratamientos();
        this.aclaracionesMedicas = mascota.getAclaracionesMedicas();
        this.aclaracionesGenerales = mascota.getAclaracionesGenerales();
    }
}
