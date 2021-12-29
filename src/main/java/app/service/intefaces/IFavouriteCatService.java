package app.service.intefaces;

import app.model.dto.ItemDTO;

import java.util.List;

public interface IFavouriteCatService {

    List<ItemDTO> getFavouriteCats(String username);
    Boolean addNewFavouriteCat(String username, int idPet) throws Exception;
}
