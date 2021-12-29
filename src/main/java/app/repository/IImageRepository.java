package app.repository;

import app.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findById(Long id);
}
