package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteCat;
import app.repository.ICatsRepository;
import app.repository.IFavouriteCatRepository;
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
    public List<ItemDTO> getFavouriteCats(String username) {
        return getFavouritesList(username);
    }

    @Override
    public Boolean addNewFavouriteCat(String username, int idPet) throws Exception {
        return addNewFavouritePet(username, idPet, FavouriteCat.class);
    }
}
