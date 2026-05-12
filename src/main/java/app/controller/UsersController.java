package app.controller;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.dto.request.EmailUserRequest;
import app.model.dto.request.RegisterRequest;
import app.model.dto.request.UpdateProfilePhotoRequestDTO;
import app.model.dto.response.CloackUserResponse;
import app.model.entity.User;
import app.service.common.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<CloackUserResponse> login(@RequestBody EmailUserRequest emailRequest, @RequestHeader("password") String password) throws WrongPasswordException, UserDoesntExistException {
        return ok(usersService.logIn(new AccountDTO(emailRequest.getEmail(), password)));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Boolean> resetPassword(@RequestHeader("email") String email) throws UserDoesntExistException {
        return ok(usersService.resetPassword(email));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest user, @RequestHeader("password") String password) {
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

    @PutMapping("/profile-photo")
    public ResponseEntity<UserDTO> updateProfilePhoto(@RequestHeader("email") String email, @RequestBody @Valid UpdateProfilePhotoRequestDTO request) throws UserDoesntExistException {
        return ok(usersService.updateProfilePhoto(email, request));
    }
}
