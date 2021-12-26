package app.service;

import app.model.dto.MascotaDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface IPerroService {
    List<MascotaDTO> getList() throws MessagingException;
    MascotaDTO altaMascota(MascotaDTO mascota);
}
