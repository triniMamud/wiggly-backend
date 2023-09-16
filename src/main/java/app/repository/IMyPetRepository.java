package app.repository;

import app.model.entity.FavouritePet;
import app.model.entity.MyPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMyPetRepository extends JpaRepository<MyPet, Long>, JpaSpecificationExecutor {
    Optional<MyPet> findByEmail(String email);

    @Modifying
    @Query("DELETE FROM MyPet mp WHERE mp.email = ?1 AND mp.petId = ?2")
    void deleteByEmailAndIdPet(String email, long petId);

    List<MyPet> getMyPetsByEmail(String email);

    /* void deleteBypet(int petId);*/
}
