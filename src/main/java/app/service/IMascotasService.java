package app.service;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;

import javax.mail.MessagingException;
import java.util.List;

public interface IMascotasService {
    List<MascotaDTO> getList(MascotasEnum mascotasEnum) throws MessagingException;
    MascotaDTO altaMascota(MascotaDTO mascota,MascotasEnum mascotasEnum);
}
