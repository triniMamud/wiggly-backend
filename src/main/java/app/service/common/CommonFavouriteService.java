package app.service.common;

import app.controller.config.Utils;
import app.model.FavouritePet;
import app.model.dto.ItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public class CommonFavouriteService<S extends JpaRepository, T extends JpaRepository, R extends FavouritePet> {

    private final S repository;
    private final T favouriteRepository;

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public CommonFavouriteService(S repository, T favouriteRepository) {
        this.repository = repository;
        this.favouriteRepository = favouriteRepository;
    }

    public List<ItemDTO> getFavouritesList(String username) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteRepository.findAll()
                .stream().filter(item -> ((FavouritePet) item).getUsername().equalsIgnoreCase(username))
                .forEach(fav -> favourites.add(mapper.map(repository.findById(((FavouritePet) fav).getId()).get(), ItemDTO.class)
                ));
        return favourites;
    }

    public Boolean addNewFavouritePet(String username, int idPet, Class<R> petType) throws Exception {
        FavouritePet favPet = petType.getConstructor(String.class,int.class).newInstance(username,idPet);

        if (Utils.safeIsEmpty(favouriteRepository.findAll(Example.of(favPet)))){
            return (favouriteRepository.save(favPet) != null);
        }

        return false;
    }

}
