package app.repository;

import app.model.entity.FavouritePet;
import app.model.entity.MyPostulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMyPostulationsRepository extends JpaRepository<MyPostulation, Long> {
    /* deleteBypet(int petId);*/
    Optional<MyPostulation> findByUser(String email);

    void deleteByEmailAndIdPet(String email, long petId);
}
