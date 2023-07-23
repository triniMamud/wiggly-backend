package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class SavePetException extends PetAdoptionException {
    public SavePetException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, new ErrorDTO("Save Pet Exception", "The pet couldn't be saved"));
    }
}
