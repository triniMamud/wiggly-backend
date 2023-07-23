package app.controller;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.service.common.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/log_in")
    public ResponseEntity<Void> login(@RequestBody AccountDTO account) throws WrongPasswordException, UserDoesntExistException {
        return ResponseEntity.ok(usersService.logIn(account));
    }

    @PostMapping("/sing_up")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO user, @RequestHeader("password") String password) throws UserAlreadyTakenException, UnderAgeException {
        return ResponseEntity.ok(usersService.signUpUser(user, password));
    }
}
