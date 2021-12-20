package app.service;

import app.model.Mascota;
import app.model.dto.MascotaDTO;
import app.model.entity.Perro;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerrosService implements IPerrosService {

    @Autowired
    IPerrosRepository perrosRepository;

    @Override
    public List<MascotaDTO> getPerrosList() {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        perrosRepository.findAll()
                .stream()
                .map(perro -> mascotasList.add(new MascotaDTO(perro)))
                .collect(Collectors.toList());
        return mascotasList;
    }

    @Override
    public MascotaDTO altaPerro(MascotaDTO mascota) {
        perrosRepository.save(new Perro(mascota));
        return mascota;
    }
}
