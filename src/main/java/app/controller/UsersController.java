package app.controller;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongUserOrPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.service.intefaces.IUsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    private IUsersService usersService;

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/log_in")
    public ResponseEntity<Void> login(@RequestBody AccountDTO account) throws WrongUserOrPasswordException, UserDoesntExistException {
        return new ResponseEntity<>(usersService.logIn(account),HttpStatus.OK);
    }

    @PostMapping("/sing_up")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user, @RequestHeader("password") String password) throws UserAlreadyTakenException, UnderAgeException {
        return new ResponseEntity<>(usersService.signUpUser(user, password), HttpStatus.OK);
    }
}
