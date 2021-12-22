package app.model;

import app.model.dto.MascotaBuilderDTO;
import app.model.dto.MascotaDTO;

public enum MascotasEnum {

    PERRO {
        @Override
        public MascotaBuilderDTO setDto (Mascota mascota) {
            return MascotaBuilderDTO.create().setPerro(mascota);
            return null;
        }
    };

    public abstract MascotaBuilderDTO setDto(Mascota mascota);
}
