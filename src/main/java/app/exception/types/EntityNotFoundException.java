package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends PetAdoptionException {
    public EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND, new ErrorDTO("Entity Not Found", "The requested entity doesn't exist"));
    }
}
