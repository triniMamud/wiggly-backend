package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteDog;
import app.repository.IFavouriteDogRepository;
import app.repository.IPerrosRepository;
import app.service.common.CommonFavouriteService;
import app.service.intefaces.IFavouritePerroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouritePerroService extends CommonFavouriteService<IPerrosRepository,IFavouriteDogRepository, FavouriteDog> implements IFavouritePerroService {

    public FavouritePerroService(IPerrosRepository repository, IFavouriteDogRepository favouriteRepository) {
        super(repository, favouriteRepository);
    }

    @Override
    public List<ItemDTO> getFavourites(String user) {
        return getFavouritesList(user);
    }

    @Override
    public Boolean addNewFavourite(String id_usuario, int id_mascota) throws Exception {
        return addNewFavouritePet(id_usuario, id_mascota, FavouriteDog.class);
    }
}
