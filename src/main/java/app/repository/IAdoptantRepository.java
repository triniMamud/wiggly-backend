package app.repository;

import app.model.entity.Adoptant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAdoptantRepository extends JpaRepository<Adoptant, Integer> {
    void deleteByEmailAndIdPet(String email, long petId);
    /*void deleteBypet(int petId);
    List<Adoptant> findBypets(int petId);*/
}
