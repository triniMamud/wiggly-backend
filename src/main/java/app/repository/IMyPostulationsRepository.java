package app.repository;

import app.model.entity.MyPostulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMyPostulationsRepository extends JpaRepository<MyPostulations, Long> {
    /* deleteBypet(int petId);*/
    Optional<MyPostulations> findByEmail(String email);

    @Modifying
    @Query("DELETE FROM MyPostulations mp WHERE mp.email = ?1 AND ?2 MEMBER OF mp.petIds")
    void deleteByEmailAndIdPet(String email, long petId);
}
