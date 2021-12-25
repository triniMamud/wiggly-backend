package app.service;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;
import app.repository.IPerrosRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.lang.Class;


public interface IMascotasService<T> {
    List<MascotaDTO> getList(MascotasEnum mascotasEnum, Class<?> type) throws InstantiationException, IllegalAccessException;
    MascotaDTO altaMascota(MascotaDTO mascota,MascotasEnum mascotasEnum);
}
