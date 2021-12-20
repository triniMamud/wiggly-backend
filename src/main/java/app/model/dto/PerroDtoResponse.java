package app.model.dto;

import app.model.entity.Perro;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerroDtoResponse {
    private String nombrePerro;
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

    public PerroDtoResponse(Perro perro) {
        this.nombrePerro = perro.getNombrePerro();
        this.edadAprox = perro.getEdadAprox();
        this.sexo = perro.getSexo();
        this.peso = perro.getPeso();
        this.tamanio = perro.getTamanio();
        this.barrio = perro.getBarrio();
        this.castrado = perro.getCastrado();
        this.vacunas = perro.getVacunas();
        this.aclaracionesVacunas = perro.getAclaracionesVacunas();
        this.desparacitado = perro.getDesparacitado();
        this.enfermedadesYTratamientos = perro.getEnfermedadesYTratamientos();
        this.aclaracionesMedicas = perro.getAclaracionesMedicas();
        this.aclaracionesGenerales = perro.getAclaracionesGenerales();
    }
}
