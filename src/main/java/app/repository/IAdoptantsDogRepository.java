package app.repository;

import app.model.entity.AdoptantDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdoptantsDogRepository extends JpaRepository<AdoptantDog, Integer> {
}
