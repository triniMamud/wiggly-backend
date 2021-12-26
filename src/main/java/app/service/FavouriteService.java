package app.service;

import app.mapper.ItemDogMapper;
import app.model.dto.ItemDogDTO;
import app.model.entity.FavouriteDog;
import app.repository.IFavouriteDogRepository;
import app.repository.IPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteService implements IFavouriteService{

    @Autowired
    IFavouriteDogRepository favouriteDogRepository;
    @Autowired
    IPerrosRepository perrosRepository;

    @Override
    public List<ItemDogDTO> getFavouriteDogs(String user) {
        List<ItemDogDTO> favourites = new ArrayList<>();
        favouriteDogRepository.getFavouriteDogByUsuario(user)
                .stream()
                .forEach(fav -> favourites.add(ItemDogMapper.newItemDogDTO(perrosRepository.findById(fav.getId()))
                ));
        return favourites;
    }

    @Override
    public Boolean addNewFavourite(String id_usuario, int id_perro) {
        favouriteDogRepository.save(new FavouriteDog(id_usuario,id_perro));
        return true;
    }
}
