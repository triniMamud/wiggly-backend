package app.repository;

import app.model.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatsRepository extends JpaRepository<Cat, Integer>  {

    List<Cat> findByTamanio(String tamanio);

    List<Cat> findBySexo(String sexo);

    Cat findById(int id);

}
