package app.service;

import app.model.dto.ItemDogDTO;

import java.util.List;

public interface IFavouriteService {
    List<ItemDogDTO> getFavouriteDogs(String user);
    Boolean addNewFavourite(String id_usuario, int id_perro);
}
