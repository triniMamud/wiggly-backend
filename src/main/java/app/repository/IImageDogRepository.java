package app.repository;

import app.model.entity.PetImageDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageDogRepository extends JpaRepository<PetImageDog, Integer> {
}
