package app.service.intefaces;

import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;

import java.util.List;

public interface IDogService {
    List<PetDTOResponse> getDogsList() throws Exception;
    PetDTOResponse addNewDog(PetDTORequest petRequest) throws Exception;
    PetDTOResponse editDog(int idPerro, PetDTORequest petRequest) throws Exception;
}
