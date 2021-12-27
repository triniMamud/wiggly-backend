package app.repository;

import app.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(Long id);
}
