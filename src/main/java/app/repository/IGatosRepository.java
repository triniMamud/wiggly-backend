package app.repository;

import app.model.entity.Gato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGatosRepository extends JpaRepository<Gato, Integer>  {

    List<Gato> findByTamanio(String tamanio);

    List<Gato> findBySexo(String sexo);

    Gato findById(int id);

}
