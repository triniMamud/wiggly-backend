package app.controller;

import app.model.dto.ItemDTO;
import app.model.dto.UserFullDTO;
import app.model.dto.request.CreateMyPostulationsRequest;
import app.model.dto.request.UpdateMyPostulationsRequest;
import app.model.dto.response.MyPostulationsDTO;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.service.common.MyPostulationsService;
import com.amazonaws.services.globalaccelerator.model.CreateAcceleratorRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/misPostulaciones")
public class MyPostulationsController {

    private final MyPostulationsService myPostulationsService;

    @GetMapping("/{petId}")
    public ResponseEntity<List<UserFullDTO>> getPetMyPostulations(@PathVariable(name = "petId") Long petId) {
        try {
            return ok(myPostulationsService.getUsersPetMyPostulations(petId));
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PetAdoptionResponseDTO>> getMyPostulations(@RequestHeader("email") String email) {
        try {
            return ok(myPostulationsService.getMyPostulations(email));
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<MyPostulationsDTO> addPostulation(@RequestHeader("email") String email, @RequestBody @Valid CreateMyPostulationsRequest request) {
        return ok(myPostulationsService.postulate(email, request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyPostulationsDTO> updatePostulationStatus(@PathVariable("id") Long id, @RequestBody @Valid UpdateMyPostulationsRequest request) {
        return ok(myPostulationsService.updateStatus(id, request.getStatus()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        myPostulationsService.delete(id);

        return noContent().build();
    }

}
