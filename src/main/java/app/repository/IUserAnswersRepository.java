package app.repository;

import app.model.entity.User;
import app.model.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserAnswersRepository  extends JpaRepository<UserAnswer, Long> {
    Optional<UserAnswer> findByEmail(String email);

}
