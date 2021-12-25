package app.repository;

import app.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {
}
