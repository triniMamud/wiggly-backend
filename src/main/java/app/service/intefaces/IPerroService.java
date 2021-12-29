package app.service.intefaces;

import app.model.dto.MascotaDTO;
import app.model.dto.MascotaDTORequest;
import app.model.dto.MascotaDTOResponse;

import javax.mail.MessagingException;
import java.util.List;

public interface IPerroService {
    List<MascotaDTOResponse> getList() throws MessagingException;
    MascotaDTOResponse altaMascota(MascotaDTORequest mascota) throws Exception;
    MascotaDTO editPerro(int idPerro, MascotaDTO mascotaDTO) throws Exception;
}
