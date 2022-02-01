package app.repository;

import app.model.entity.MyDogs;
import app.model.entity.MyPostulations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyPostulationsRepository extends JpaRepository<MyPostulations, Integer> {
}
