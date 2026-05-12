package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UnderAgeException extends PetAdoptionException {
    public UnderAgeException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Can't sing up", "Users under 13 can't sing up"));
    }
}
