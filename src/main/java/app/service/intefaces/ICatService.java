package app.service.intefaces;

import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;

import javax.mail.MessagingException;
import java.util.List;

public interface ICatService {
    List<PetDTOResponse> getCatsList() throws MessagingException;
    PetDTOResponse addNewCat(PetDTORequest mascota) throws Exception;
    PetDTO editCat(int idPerro, PetDTO petDTO) throws Exception;
}
