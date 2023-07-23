package app.repository;

import app.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
//
//    boolean existsAccountByUsername(String username);
//
//    @Query("SELECT password FROM Account WHERE username = :username")
//    String getUserPassword(String username);
}
