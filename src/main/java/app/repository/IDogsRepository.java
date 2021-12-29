package app.repository;

import app.model.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDogsRepository extends JpaRepository<Dog, Integer> {

    List<Dog> findByTamanio(String tamanio);

    List<Dog> findBySexo(String sexo);

    Dog findById(int id);

}