package app.repository;

import app.model.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPerrosRepository extends JpaRepository<Perro, Integer> {

    List<Perro> findByTamanio(String tamanio);

    List<Perro> findBySexo(String sexo);

}