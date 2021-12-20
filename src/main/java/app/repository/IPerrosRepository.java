package app.repository;

import app.model.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPerrosRepository extends JpaRepository<Perro, Integer> {

    @Query("FROM Perros WHERE barrio LIKE %barrio%")
    List<Perro> getPerroByBarrio(String barrio);

    List<Perro> findByTamanio(String tamanio);

    List<Perro> findBySexo(String sexo);

}