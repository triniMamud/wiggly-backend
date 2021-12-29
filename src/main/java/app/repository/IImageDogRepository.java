package app.repository;

import app.model.entity.ImageCat;
import app.model.entity.ImageDog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageDogRepository extends JpaRepository<ImageDog, Integer> {
}
