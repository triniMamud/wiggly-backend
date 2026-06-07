package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class AlreadyPostulatedException extends PetAdoptionException {
    public AlreadyPostulatedException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Already Postulated","Ya enviaste una postulación para esta mascota"));
    }
}
