package app.service.common;

import app.mapper.ItemMapper;
import app.model.Mascota;
import app.model.dto.ItemDTO;
import app.model.dto.MascotaDTO;
import app.model.entity.FavouriteDog;
import app.model.FavouritePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CommonFavouriteService<S extends JpaRepository, T extends JpaRepository, R extends FavouritePet> {

    @Autowired
    S repository;
    @Autowired
    T favouriteRepository;

    public List<ItemDTO> getFavouritesList(String user) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteRepository.findAll()
                .stream().filter(item -> ((FavouritePet) item).getUsuario().equalsIgnoreCase(user))
                .forEach(fav -> favourites.add(ItemMapper.newItemDTO((Mascota) repository.findById(((FavouritePet) fav).getId()).get())
                ));
        return favourites;
    }

    public Boolean addNewFavouritePet(String id_usuario, int id_perro, Class<R> mascotaType) throws Exception {
        favouriteRepository.save(mascotaType.getConstructor(String.class,int.class).newInstance(id_usuario, id_perro));
        return true;
    }

}
