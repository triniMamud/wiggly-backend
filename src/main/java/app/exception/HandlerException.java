package app.exception;

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

}
