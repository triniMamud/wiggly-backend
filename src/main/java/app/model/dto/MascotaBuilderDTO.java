package app.model.dto;

import app.model.Mascota;
import app.model.entity.Gato;
import app.model.entity.Perro;

public class MascotaBuilderDTO {
    private GatoDTO gato = new GatoDTO();
    private PerroDTO perro = new PerroDTO();

    public static MascotaBuilderDTO create(){
        return this;
    }

    public MascotaBuilderDTO setGato(GatoDTO gato) {
        this.gato = gato;
        return this;
    }

    public MascotaBuilderDTO setPerro(Mascota perro) {
        this.perro = perro;
        return this;
    }

    public MascotaDTO build() {
        return new MascotaDTO();
    }
}
