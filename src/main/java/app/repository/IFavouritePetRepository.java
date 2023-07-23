package app.repository;

import app.model.entity.FavouritePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFavouritePetRepository extends JpaRepository<FavouritePet, Long> {
    Optional<FavouritePet> findByUser(String email);
    void deleteByEmailAndIdPet(String email, long idPet);
}
