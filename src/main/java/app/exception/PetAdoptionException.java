package app.exception;

import app.model.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetAdoptionException extends Exception {
    private HttpStatus status;
    private ErrorDTO error;
}
