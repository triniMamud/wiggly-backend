package app.controller;

import app.exception.types.DeleteEntityException;
import app.model.dto.PetDTO;
import app.model.dto.request.PetDTORequest;
import app.model.dto.request.UpdatePetRequest;
import app.model.dto.response.PetDTOResponse;
import app.service.common.MyPetsService;
import app.service.common.MyPostulationsService;
import app.service.common.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetsController {

    private final PetService petService;
    private final MyPetsService myPetsService;
    private final MyPostulationsService myPostulationsService;

    @GetMapping
    public ResponseEntity<List<PetDTOResponse>> getListPets() throws Exception {
        return ok(petService.getListPets());
    }

    @PostMapping("/alta")
    public ResponseEntity<Boolean> postNewPet(@RequestBody PetDTORequest pet, @RequestHeader("email") String email) {
        try {
            return ok(petService.addNewPet(pet, email));
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> update(@PathVariable("id") Long id, @RequestBody @Valid UpdatePetRequest updatePetRequest) {
        return ok(petService.update(id, updatePetRequest));
    }

    /*@GetMapping("/list/{idPerro}")
    public ResponseEntity<PetDTOResponse> getPet(@PathVariable int idDog) {
        return ok(petService.getPet(idDog));
    }*/

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> deletePet(@RequestHeader("email") String email, @RequestBody long petId) throws DeleteEntityException {
        petService.deletePet(email, petId);
        return noContent().build();
    }
}
