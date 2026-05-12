package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserDoesntExistException extends PetAdoptionException {
    public UserDoesntExistException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("User not found", "The user doesn't exist"));
    }
}
