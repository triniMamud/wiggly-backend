package app.exception;

import app.exception.types.EntityNotFoundException;
import app.exception.types.ImagesNotSavedException;
import app.model.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(PetAdoptionException.class)
    public ResponseEntity<ErrorDTO> petAdoptionException(PetAdoptionException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> entityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(ImagesNotSavedException.class)
    public ResponseEntity<ErrorDTO> imagesNotSavedException(ImagesNotSavedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

}
