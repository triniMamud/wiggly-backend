package app.repository;

import app.model.entity.FavouritePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFavouritePetRepository extends JpaRepository<FavouritePet, Long> {

    @Modifying
    @Query("DELETE FROM FavouritePet fp WHERE fp.email = ?1 AND ?2 MEMBER OF fp.petIds")
    void deleteByEmailAndIdPet(String email, long idPet);

    Optional<FavouritePet> findByEmail(String email);

}
