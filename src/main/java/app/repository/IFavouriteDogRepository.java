package app.repository;

import app.model.entity.FavouriteDog;
import app.model.FavouritePet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavouriteDogRepository extends JpaRepository<FavouriteDog, Integer> {

    List<FavouritePet> getFavouriteByUsuario(String id_usuario);
}
