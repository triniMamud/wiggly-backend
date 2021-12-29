package app.service.intefaces;

import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;

import javax.mail.MessagingException;
import java.util.List;

public interface IDogService {
    List<PetDTOResponse> getList() throws MessagingException;
    PetDTOResponse altaMascota(PetDTORequest mascota) throws Exception;
    PetDTO editPerro(int idPerro, PetDTO petDTO) throws Exception;
}
