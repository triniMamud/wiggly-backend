package app.repository;

import app.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long>, JpaSpecificationExecutor {

    Pet getPetById(Long petId);

    @Query("UPDATE Pet p SET p.isFavPet = :isFavPet WHERE p.petId = :petId")
    void updateFav(Long petId, boolean isFavPet);
}