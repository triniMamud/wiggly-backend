package app.service.intefaces;

import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;

import java.util.List;

public interface ICatService {
    List<PetDTOResponse> getCatsList() throws Exception;
    PetDTOResponse addNewCat(PetDTORequest petRequest) throws Exception;
    PetDTOResponse editCat(int idDog, PetDTORequest petRequest) throws Exception;
    PetDTOResponse getCat(int idCat);
}
