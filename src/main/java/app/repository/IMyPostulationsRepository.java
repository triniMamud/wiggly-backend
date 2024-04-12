package app.repository;

import app.model.entity.MyPostulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMyPostulationsRepository extends JpaRepository<MyPostulations, Long> {
    /* deleteBypet(int petId);*/
    Optional<MyPostulations> findByEmail(String email);

    Optional<List<MyPostulations>> findAllByEmail(String email);

    Optional<MyPostulations> findByEmailAndPetId(String email, Long petId);

    Optional<List<MyPostulations>> findByPetId(Long petId);

    @Modifying
    @Query("DELETE FROM MyPostulations mp WHERE mp.email = ?1 AND ?2 = petId")
    void deleteByEmailAndIdPet(String email, long petId);
}
