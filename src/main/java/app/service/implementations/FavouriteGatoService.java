package app.service.implementations;

import app.model.dto.ItemDTO;
import app.model.entity.FavouriteCat;
import app.repository.IFavouriteCatRepository;
import app.repository.IGatosRepository;
import app.service.common.CommonFavouriteService;
import app.service.intefaces.IFavouriteGatoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteGatoService extends CommonFavouriteService<IGatosRepository,IFavouriteCatRepository, FavouriteCat> implements IFavouriteGatoService {

    public FavouriteGatoService(IGatosRepository repository, IFavouriteCatRepository favouriteRepository) {
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
