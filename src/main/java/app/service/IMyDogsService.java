package app.service;

import app.model.dto.ItemDTO;
import app.model.dto.PostulantesDTO;

import java.util.List;

public interface IMyDogsService {

    List<ItemDTO> getMyDogs (String username);
    void addToMyDogs (int idDog, String username) throws Exception;
    List<PostulantesDTO> getAdoptantsDog (int idDog);
}
