package app.repository;

import app.model.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDogsRepository extends JpaRepository<Dog, Integer> {
}