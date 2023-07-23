package app.exception.types;

import app.exception.PetAdoptionException;
import app.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DeleteEntityException extends PetAdoptionException {
    public DeleteEntityException() {
        super(HttpStatus.NOT_FOUND, new ErrorDTO("Delete Entity Exception", "The entity couldn' be deleted"));
    }
}