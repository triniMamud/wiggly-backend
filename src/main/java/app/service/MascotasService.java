package app.service;

import app.patterns.MascotaFactory;
import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;
import app.model.dto.PerroDTO;
import app.model.entity.Perro;
import org.springframework.stereotype.Service;
import java.lang.Class;

import java.util.ArrayList;
import java.util.List;


import static app.patterns.ProviderPattern.PROVIDERS;

@Service
public class MascotasService implements IMascotasService {

    

    @Override
    public List<MascotaDTO> getList(MascotasEnum mascotasEnum, Class<?> type) {

        MascotaFactory mascotaFactory = new MascotaFactory<>();
        List<MascotaDTO> mascotasList = new ArrayList<>();

        PROVIDERS.get(mascotasEnum.name()).get();

        (mascotaFactory.getRepository(mascotasEnum, type));
                perrosRepository.findAll()
                .stream()
                .forEach(perro -> mascotasList.add(new PerroDTO(perro)));
        return mascotasList;
    }

    @Override
    public MascotaDTO altaMascota(MascotaDTO mascota, MascotasEnum tipoMascota) {
        perrosRepository.save(new Perro(perro));
        return mascota;
    }
}
