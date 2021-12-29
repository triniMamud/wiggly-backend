package app.repository;

import app.model.entity.MyCats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyCatsRepository extends JpaRepository<MyCats, Integer>  {
}
