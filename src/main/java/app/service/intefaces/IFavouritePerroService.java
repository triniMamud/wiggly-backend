package app.service.intefaces;

import app.model.dto.ItemDTO;

import java.util.List;

public interface IFavouritePerroService {
    List<ItemDTO> getFavourites(String user);
    Boolean addNewFavourite(String id_usuario, int id_mascota) throws Exception;
}
