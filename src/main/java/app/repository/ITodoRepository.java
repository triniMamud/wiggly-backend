package app.repository;

import app.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(Long id);
}
