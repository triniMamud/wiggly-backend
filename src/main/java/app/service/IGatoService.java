package app.service;

import app.model.dto.MascotaDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface IGatoService {
    List<MascotaDTO> getGatosList() throws MessagingException;
    MascotaDTO altaGato(MascotaDTO mascota) throws Exception;
    MascotaDTO editCat(int idPerro, MascotaDTO mascotaDTO) throws Exception;
}
