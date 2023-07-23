package app.repository;

import app.model.entity.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetImageRepository extends JpaRepository<PetImage, Long> {

    List<PetImage> findByid(long id);
    void deleteByidPet(int id);
}
