package app.service.common;

import app.model.FavouritePet;
import app.model.dto.ItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Boolean addNewFavouritePet(String username, int idDog, Class<R> petType) throws Exception {
        return (favouriteRepository.save(petType.getConstructor(String.class,int.class).newInstance(username, idDog)) != null);
    }

}
