package app.repository;

import app.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountsRepository extends JpaRepository<Account, Integer> {

    boolean existsAccountByUsuario(String usuario);

    @Query("SELECT password FROM Account WHERE usuario = :user")
    String getUserPssw(String user);
}
