package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserAlreadyTakenException extends PetAdoptionException {
    public UserAlreadyTakenException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("User not available", "The user already exists"));
    }
}
