package app.repository;

import app.model.dto.UserDTO;
import app.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update User u set u.isFormAnswered = :isFormAnswered where u.email = :email")
    void updateIsFormAnswered(@Param("email") String email, @Param("isFormAnswered") boolean isFormAnswered);

    @Query("select u.isFormAnswered from User u where u.email = :email")
    Boolean getIsFormAnswered(@Param("email") String email);
}
