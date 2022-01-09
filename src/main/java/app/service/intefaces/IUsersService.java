package app.service.intefaces;

import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;

public interface IUsersService {
    UserDTO signUpUser(UserDTO user, String password);
    Boolean logIn(AccountDTO accountDTO);
}
