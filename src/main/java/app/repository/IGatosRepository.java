package app.repository;

import app.model.entity.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGatosRepository extends JpaRepository<Gato, Integer>  {

    List<Gato> findByTamanio(String tamanio);

    List<Gato> findBySexo(String sexo);

    Gato findById(int id);

}
