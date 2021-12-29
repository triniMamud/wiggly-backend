package app.repository;

import app.model.entity.FavouriteDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavouriteCatRepository extends JpaRepository<FavouriteDog, Integer> {
}
