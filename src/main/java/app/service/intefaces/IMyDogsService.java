package app.service.intefaces;

import app.model.dto.ItemDTO;
import app.model.dto.AdoptantDTO;

import java.util.List;

public interface IMyDogsService {

    List<ItemDTO> getMyDogs (String username);
    void addToMyDogs (int idDog, String username) throws Exception;
    List<AdoptantDTO> getAdoptantsDog (int idDog);
}
