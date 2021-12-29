package app.repository;

import app.model.entity.MyDogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyDogsRepository extends JpaRepository<MyDogs, Integer> {

}
