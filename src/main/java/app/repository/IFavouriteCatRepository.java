package app.repository;

import app.model.entity.FavouriteDog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavouriteCatRepository extends JpaRepository<FavouriteDog, Integer> {

    List<FavouriteDog> getFavouriteByUsuario(String id_usuario);
}
