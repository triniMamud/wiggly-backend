package app.repository;

import app.model.entity.HouseImage;
import app.model.entity.PetImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHouseImageRepository extends JpaRepository<HouseImage, Long> {

    List<HouseImage> findByEmail(String petId);
}
