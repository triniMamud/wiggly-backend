package app.service.common;

import app.mapper.ItemMapper;
import app.model.Pet;
import app.model.dto.ItemDTO;
import app.model.FavouritePet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class CommonFavouriteService<S extends JpaRepository, T extends JpaRepository, R extends FavouritePet> {

    private S repository;
    private T favouriteRepository;

    public CommonFavouriteService(S repository, T favouriteRepository) {
        this.repository = repository;
        this.favouriteRepository = favouriteRepository;
    }

    public List<ItemDTO> getFavouritesList(String user) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteRepository.findAll()
                .stream().filter(item -> ((FavouritePet) item).getUsuario().equalsIgnoreCase(user))
                .forEach(fav -> favourites.add(ItemMapper.newItemPetDTO((Pet) repository.findById(((FavouritePet) fav).getId()).get())
                ));
        return favourites;
    }

    public Boolean addNewFavouritePet(String id_usuario, int id_perro, Class<R> mascotaType) throws Exception {
        favouriteRepository.save(mascotaType.getConstructor(String.class,int.class).newInstance(id_usuario, id_perro));
        return true;
    }

}
