package app.service.intefaces;

import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;

public interface IUsersService {
    UserDTO altaUsuario(UserDTO usuario, String password);
    Void logIn(AccountDTO accountDTO);
}
