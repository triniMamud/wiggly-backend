package app.service;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;

import java.util.List;

public interface IMascotasService {
    List<MascotaDTO> getList(MascotasEnum mascotasEnum);
    MascotaDTO altaMascota(MascotaDTO mascota,MascotasEnum mascotasEnum);
}
