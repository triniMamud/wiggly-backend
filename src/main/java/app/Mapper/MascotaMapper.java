package app.Mapper;

import app.model.Mascota;
import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.Gato;
import app.model.entity.Perro;

import javax.persistence.Column;

public class MascotaMapper {

    public static Gato newGato(MascotaDTO gatoDTO) {
        return new Gato(gatoDTO.getId(),gatoDTO.getNombre(),gatoDTO.getEdadAprox(),gatoDTO.getSexo(),
                        gatoDTO.getTamanio(),gatoDTO.getBarrio(),gatoDTO.getCastrado(),gatoDTO.getVacunas(),
                        gatoDTO.getAclaracionesVacunas(),gatoDTO.getDesparacitado(),gatoDTO.getEnfermedadesYTratamientos(),
                        gatoDTO.getAclaracionesMedicas(),gatoDTO.getAclaracionesGenerales());
    }

    public static Perro newPerro(MascotaDTO perroDTO) {
        return new Perro(perroDTO.getId(), perroDTO.getNombre(), perroDTO.getEdadAprox(), perroDTO.getSexo(),
                perroDTO.getTamanio(), perroDTO.getBarrio(), perroDTO.getCastrado(), perroDTO.getVacunas(),
                perroDTO.getAclaracionesVacunas(), perroDTO.getDesparacitado(), perroDTO.getEnfermedadesYTratamientos(),
                perroDTO.getAclaracionesMedicas(), perroDTO.getAclaracionesGenerales());
    }

    public static GatoDTO newGatoDTO(Mascota gato) {
        return new GatoDTO(gato.getId(),gato.getNombre(),gato.getEdadAprox(),gato.getSexo(),
                gato.getTamanio(),gato.getBarrio(),gato.getCastrado(),gato.getVacunas(),
                gato.getAclaracionesVacunas(),gato.getDesparacitado(),gato.getEnfermedadesYTratamientos(),
                gato.getAclaracionesMedicas(),gato.getAclaracionesGenerales());
    }

    public static PerroDTO newPerroDTO(Mascota perro) {
        return new PerroDTO(perro.getId(),perro.getNombre(),perro.getEdadAprox(),perro.getSexo(),
                perro.getTamanio(),perro.getBarrio(),perro.getCastrado(),perro.getVacunas(),
                perro.getAclaracionesVacunas(),perro.getDesparacitado(),perro.getEnfermedadesYTratamientos(),
                perro.getAclaracionesMedicas(),perro.getAclaracionesGenerales());
    }
}
