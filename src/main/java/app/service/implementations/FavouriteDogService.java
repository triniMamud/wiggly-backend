package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteDog;
import app.repository.IFavouriteDogRepository;
import app.repository.IDogsRepository;
import app.service.common.CommonFavouriteService;
import app.service.intefaces.IFavouriteDogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteDogService extends CommonFavouriteService<IDogsRepository,IFavouriteDogRepository, FavouriteDog> implements IFavouriteDogService {

    public FavouriteDogService(IDogsRepository repository, IFavouriteDogRepository favouriteRepository) {
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
