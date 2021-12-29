package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteCat;
import app.repository.IFavouriteCatRepository;
import app.repository.ICatsRepository;
import app.service.common.CommonFavouriteService;
import app.service.intefaces.IFavouriteCatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteCatService extends CommonFavouriteService<ICatsRepository,IFavouriteCatRepository, FavouriteCat> implements IFavouriteCatService {

    public FavouriteCatService(ICatsRepository repository, IFavouriteCatRepository favouriteRepository) {
        super(repository, favouriteRepository);
    }

    @Override
    public List<ItemDTO> getFavourites(String user) {
        return getFavouritesList(user);
    }

    @Override
    public Boolean addNewFavourite(String id_usuario, int id_mascota) throws Exception {
        return addNewFavouritePet(id_usuario, id_mascota, FavouriteCat.class);
    }
}
