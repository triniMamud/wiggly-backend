package app.repository;

import app.model.dto.PostulantesDTO;
import app.model.entity.MyDogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMyDogsRepository extends JpaRepository<MyDogs, Integer> {

}
