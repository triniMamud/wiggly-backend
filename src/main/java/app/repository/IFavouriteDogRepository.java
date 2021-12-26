package app.repository;

import app.model.entity.FavouriteDog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavouriteDogRepository extends JpaRepository<FavouriteDog, Integer> {

    List<FavouriteDog> getFavouriteDogByUsuario(String id_usuario);
}
