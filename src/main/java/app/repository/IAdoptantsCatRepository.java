package app.repository;

import app.model.entity.AdoptantCat;
import app.model.entity.AdoptantDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdoptantsCatRepository extends JpaRepository<AdoptantCat, Integer> {
}
