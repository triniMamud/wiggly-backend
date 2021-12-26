package app.service.intefaces;

import app.model.dto.ItemDTO;

import java.util.List;

public interface IFavouriteService {
    List<ItemDTO> getFavouriteDogs(String user);
    Boolean addNewFavouriteDog(String id_usuario, int id_perro);
    List<ItemDTO> getFavouriteCats(String user);
    Boolean addNewFavouriteCat(String id_usuario, int id_perro);
}
