package app.service;

import app.model.dto.MascotaDTO;

import java.util.List;

public interface IPerrosService {
    List<MascotaDTO> getPerrosList();
    MascotaDTO altaPerro(MascotaDTO mascota);
}
