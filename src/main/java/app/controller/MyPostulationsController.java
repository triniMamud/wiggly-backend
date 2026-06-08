package app.controller;

import app.exception.types.AlreadyPostulatedException;
import app.exception.types.EntityNotFoundException;
import app.model.dto.UserFullDTO;
import app.model.dto.request.AbmMyPostulationReq;
import app.model.dto.request.UpdateMyPostulationsRequest;
import app.model.dto.response.MyPostulationsDTO;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.service.common.MyPostulationsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
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
    public ResponseEntity<MyPostulationsDTO> addPostulation(@RequestHeader("email") String email, @RequestBody @Valid AbmMyPostulationReq request) throws AlreadyPostulatedException {
        return ok(myPostulationsService.postulate(email, request));
    }

    @PutMapping
    public ResponseEntity<MyPostulationsDTO> updatePostulationStatus(@RequestHeader("email") String email, @RequestBody @Valid UpdateMyPostulationsRequest request) {
        return ok(myPostulationsService.updateStatus(email, request.getPetId(), request.getStatus()));
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelPostulation(@RequestHeader("email") String email, @RequestBody AbmMyPostulationReq request) throws EntityNotFoundException {
        myPostulationsService.deletePetFromPostulations(email, request.getPetId());
        return noContent().build();
    }
}
