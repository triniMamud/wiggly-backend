package app.service.intefaces;

import app.model.dto.MascotaDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface IGatoService {
    List<MascotaDTO> getList() throws MessagingException;
    MascotaDTO altaMascota(MascotaDTO mascota);
}
