package app.service.intefaces;

import app.model.dto.ItemDTO;
import app.model.dto.AdoptantDTO;

import java.util.List;

public interface IMyCatsService {

    List<ItemDTO> getMyCats (String username);
    void addToMyCatss (int idCat, String username) throws Exception;
    List<AdoptantDTO> getAdoptantsCat (int idCat);
}
