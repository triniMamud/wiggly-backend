package app.controller;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.service.common.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signin")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestHeader("email") String email, @RequestHeader("password") String password) throws WrongPasswordException, UserDoesntExistException {
        return ok(usersService.logIn(new AccountDTO(email, password)));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Boolean> resetPassword(@RequestHeader("email") String email) throws UserDoesntExistException {
        return ok(usersService.resetPassword(email));
    }

}
