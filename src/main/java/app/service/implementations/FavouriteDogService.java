package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteDog;
import app.repository.IDogsRepository;
import app.repository.IFavouriteDogRepository;
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
    public List<ItemDTO> getFavouriteDogs(String username) {
        return getFavouritesList(username);
    }

    @Override
    public Boolean addNewFavouriteDog(String username, int idPet) throws Exception {
        return addNewFavouritePet(username, idPet, FavouriteDog.class);
    }
}
