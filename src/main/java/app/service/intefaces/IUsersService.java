package app.service.intefaces;

import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongUserOrPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;

public interface IUsersService {
    UserDTO signUpUser(UserDTO user, String password) throws UserAlreadyTakenException;
    Void logIn(AccountDTO accountDTO) throws WrongUserOrPasswordException, UserDoesntExistException;
}
