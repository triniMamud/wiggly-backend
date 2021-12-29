package app.service.intefaces;

import app.model.dto.ItemDTO;

import java.util.List;

public interface IFavouriteDogService {
    List<ItemDTO> getFavouriteDogs(String username);
    Boolean addNewFavouriteDog(String username, int idPet) throws Exception;
}
