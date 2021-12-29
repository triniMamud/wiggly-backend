package app.service.intefaces;

import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;

import java.util.List;

public interface IMyCatsService {

    List<ItemDTO> getMyCats (String username);
    void addToMyCats(int idCat, String username) throws Exception;
    List<AdoptantDTO> getAdoptantsCat (int idCat);
}
