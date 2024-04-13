package app.repository;

import app.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {

    Pet getPetById(Long petId);

    @Modifying
    @Query("UPDATE Pet p SET p.isFavPet = ?2 WHERE p.id = ?1")
    void updateFav(Long petId, boolean isFavPet);
}