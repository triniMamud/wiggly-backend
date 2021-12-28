package app.service;

import app.model.dto.MascotaDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface IPerroService {
    List<MascotaDTO> getPerrosList() throws MessagingException;
    MascotaDTO altaPerro(MascotaDTO mascota) throws Exception;
    MascotaDTO editPerro(int idPerro, MascotaDTO mascotaDTO) throws Exception;
}
