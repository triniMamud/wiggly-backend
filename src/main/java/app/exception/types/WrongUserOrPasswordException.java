package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class WrongUserOrPasswordException extends PetAdoptionException {
    public WrongUserOrPasswordException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("The user and password doesn't match.","The user or password is incorrect."));
    }
}
