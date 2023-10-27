package app.controller;

import app.model.dto.AdoptantDTO;
import app.model.dto.FavouritePetDTO;
import app.model.dto.ItemDTO;
import app.model.dto.request.CreateAdoptantRequest;
import app.model.dto.request.CreateFavouritePetRequest;
import app.service.common.AdoptantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adoptantes")
public class AdoptantsController {

    private final AdoptantService adoptantService;

    /*@GetMapping("/{idDog}")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsByPet(@PathVariable int idPet) {
        return new ResponseEntity<>(adoptantService.getAdoptantsByPet(idPet), HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<AdoptantDTO> createAdoptant(@RequestHeader("email") String email, @RequestBody @Valid CreateAdoptantRequest request) {
        return ok(adoptantService.save(email, request.getPetId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        adoptantService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
