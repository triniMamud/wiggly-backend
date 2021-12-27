package app.repository;

import app.model.entity.FavouriteDog;
import app.model.FavouritePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFavouriteDogRepository extends JpaRepository<FavouriteDog, Integer> {

    List<FavouritePet> getFavouriteByUsuario(String id_usuario);
}
