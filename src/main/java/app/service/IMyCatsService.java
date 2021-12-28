package app.service;

import app.model.dto.ItemDTO;
import app.model.dto.PostulantesDTO;

import java.util.List;

public interface IMyCatsService {

    List<ItemDTO> getMyCats (String username);
    void addToMyCatss (int idCat, String username) throws Exception;
    List<PostulantesDTO> getAdoptantsCat (int idCat);
}
