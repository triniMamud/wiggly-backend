package app.repository;

import app.model.entity.FavouriteDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavouriteDogRepository extends JpaRepository<FavouriteDog, Integer> {
}
