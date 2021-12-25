package app.service;

import app.model.dto.GatoDTO;
import app.model.dto.MascotaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class CommonService<S extends JpaRepository, T extends  MascotaDTO> {

    @Autowired
    S repository;

    public List<MascotaDTO> getListMascotas() {
        List<MascotaDTO> mascotasList = new ArrayList<>();
        repository.findAll()
                .stream()
                .forEach(gato -> mascotasList.add(new T()));
        return mascotasList;
    }
}