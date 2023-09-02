package app.repository;

import app.model.entity.Adoptant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdoptantRepository extends JpaRepository<Adoptant, Long> {
    @Modifying
    @Query("DELETE FROM Adoptant a WHERE a.email = :email AND :petId MEMBER OF a.petIds")
    void deleteByEmailAndPetId(String email, Long petId);
    /*void deleteBypet(int petId);
    List<Adoptant> findBypets(int petId);*/
}
