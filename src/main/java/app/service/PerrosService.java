package app.service;

import app.model.MascotasEnum;
import app.model.dto.MascotaBuilderDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PerroDTO;
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

    public List<MascotaDTO> getPerrosList(MascotasEnum mascota) {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        perrosRepository.findAll()
                .stream()
                .map(perro -> mascotasList.add(MascotaBuilderDTO.create().setPerro(mascota.setDto(perro).build())))
                .collect(Collectors.toList());
        return mascotasList;
    }

    @Override
    public PerroDTO altaPerro(PerroDTO perro) {
        perrosRepository.save(new Perro(perro));
        return perro;
    }
}
