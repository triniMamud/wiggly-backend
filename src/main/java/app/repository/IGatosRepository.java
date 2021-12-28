package app.repository;

import app.model.entity.Gato;
import app.model.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGatosRepository extends JpaRepository<Gato, Integer> {

    List<Perro> findByTamanio(String tamanio);

    List<Perro> findBySexo(String sexo);

}
