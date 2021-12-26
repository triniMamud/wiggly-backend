package app.service.implementations;

import app.mapper.ItemMapper;
import app.model.dto.ItemDTO;
import app.model.entity.FavouriteDog;
import app.repository.IFavouriteCatRepository;
import app.repository.IFavouriteDogRepository;
import app.repository.IGatosRepository;
import app.repository.IPerrosRepository;
import app.service.intefaces.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteService implements IFavouriteService {

    @Autowired
    IFavouriteDogRepository favouriteDogRepository;
    @Autowired
    IFavouriteCatRepository favouriteCatRepository;
    @Autowired
    IPerrosRepository perrosRepository;
    @Autowired
    IGatosRepository gatosRepository;

    @Override
    public List<ItemDTO> getFavouriteDogs(String user) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteDogRepository.getFavouriteDogByUsuario(user)
                .stream()
                .forEach(fav -> favourites.add(ItemMapper.newItemDogDTO(perrosRepository.findById(fav.getId()))
                ));
        return favourites;
    }

    @Override
    public Boolean addNewFavouriteDog(String id_usuario, int id_perro) {
        favouriteDogRepository.save(new FavouriteDog(id_usuario,id_perro));
        return true;
    }

    @Override
    public List<ItemDTO> getFavouriteCats(String user) {
        List<ItemDTO> favourites = new ArrayList<>();
        favouriteCatRepository.getFavouriteCatByUsuario(user)
                .stream()
                .forEach(fav -> favourites.add(ItemMapper.newItemDogDTO(gatosRepository.findById(fav.getId()))
                ));
        return favourites;
    }

    @Override
    public Boolean addNewFavouriteCat(String id_usuario, int id_perro) {
        favouriteCatRepository.save(new FavouriteDog(id_usuario,id_perro));
        return true;
    }
}
