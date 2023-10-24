package app.repository;

import app.model.entity.HouseType;
import app.model.entity.MyPet;
import app.model.entity.MyPostulations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHouseTypeRepository extends JpaRepository<HouseType, Long> {
    Optional<HouseType> findByEmail(String email);
}
