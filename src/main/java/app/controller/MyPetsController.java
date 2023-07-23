package app.controller;

import app.exception.types.EntityNotFoundException;
import app.exception.types.ImagesNotSavedException;
import app.exception.types.SavePetException;
import app.model.dto.*;
import app.service.common.MyPetsService;
import app.service.common.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/misMascotas")
public class MyPetsController {

    private final MyPetsService myPetsService;
    private final PetService petService;

    /*@GetMapping("/misPerros")
    public ResponseEntity<List<ItemDTO>> getMyPets(@RequestHeader("username") String username) {
        return ok(myPetsService.getMyPets(username));
    }*/

    @PostMapping("/{idPet}/editar")
    public ResponseEntity<PetDTOResponse> editMyPet(@PathVariable("idPet") long idPet, @RequestBody PetDTORequest petRequest) throws ImagesNotSavedException, EntityNotFoundException, SavePetException {
        return ok(petService.editPet(idPet, petRequest));
    }

    /*@GetMapping("/misPerros/{idDog}/postulantes")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsPet(@PathVariable("idDog") int idDog) {
        return ok(myPetsService.getAdoptantsPet(idDog));
    }*/

    @GetMapping("/search")
    public ResponseEntity<List<ItemDTO>> searchMyPet(@RequestParam MyPetsSearchRequestParameters searchRequest) {
        return ok(myPetsService.searchMyPets(searchRequest));
    }
}
