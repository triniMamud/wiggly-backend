package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ImagesNotSavedException extends PetAdoptionException {
    public ImagesNotSavedException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, new ErrorDTO("Images Not Saved Exception", "The images couldn't be saved"));
    }
}
