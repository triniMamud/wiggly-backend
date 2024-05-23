package app.controller;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.entity.User;
import app.service.common.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

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

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody User user, @RequestHeader("password") String password) throws UserDoesntExistException {
        try {
            return ok(usersService.registerUser(user, password));
        } catch (UserAlreadyTakenException uatE) {
            return status(BAD_REQUEST).build();
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/isFormAnswered")
    public ResponseEntity<Boolean> getIsFormAnswered(@RequestHeader("email") String email) {
        return ok(usersService.getIsFormAnswered(email));
    }

}
