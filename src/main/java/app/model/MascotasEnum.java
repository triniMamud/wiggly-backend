package app.model;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
import app.model.entity.Gato;
import app.model.entity.Perro;
import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum MascotasEnum {

    PERRO {
        @Override
        public void altaMascota(MascotaDTO perro) {
            perrosRepository.save(new Perro(perro));
        }

        @Override
        public List<MascotaDTO> getListMascotas() {
            List<MascotaDTO> mascotasList = new ArrayList<>();
            perrosRepository.findAll()
                    .stream()
                    .forEach(perro -> mascotasList.add(new PerroDTO(perro)));
            return mascotasList;
        }
    },

    GATO {
        @Override
        public void altaMascota(MascotaDTO gato) {
            gatosRepository.save(new Gato(gato));
        }

        @Override
        public List<MascotaDTO> getListMascotas() {
            List<MascotaDTO> mascotasList = new ArrayList<>();
            gatosRepository.findAll()
                    .stream()
                    .forEach(gato -> mascotasList.add(new GatoDTO(gato)));
            return mascotasList;
        }
    };

    @Component
    public static class InjectorMascotas {
        @Autowired
        IPerrosRepository perrosRepository;
        @Autowired
        IGatosRepository gatosRepository;

        @PostConstruct
        public void postConstruct() {
            for(MascotasEnum rt : EnumSet.allOf(MascotasEnum.class)) {
                rt.setPerrosRepository(perrosRepository);
                rt.setGatosRepository(gatosRepository);
            }
        }
    }

    IPerrosRepository perrosRepository;
    IGatosRepository gatosRepository;

    public abstract void altaMascota(MascotaDTO mascotaDTO);
    public abstract List<MascotaDTO> getListMascotas();

    public void setPerrosRepository(IPerrosRepository perrosRepository) {
        this.perrosRepository = perrosRepository;
    }
    public void setGatosRepository(IGatosRepository gatosRepository) {
        this.gatosRepository = gatosRepository;
    }
}
