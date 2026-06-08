package app.repository;

import app.model.entity.Pet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {

    Pet getPetById(Long petId);

    @Transactional
    @Modifying
    @Query("update Pet p set p.isFavPet = :isFavPet where p.id = :id")
    void updateFav(@Param("id") Long petId, @Param("isFavPet") boolean isFavPet);
}