package app.repository;

import app.model.entity.MyCats;
import app.model.entity.MyDogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyCatsRepository extends JpaRepository<MyCats, Integer>  {
}
