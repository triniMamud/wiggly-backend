package app.controller;

import app.model.dto.FavouritePetDTO;
import app.model.dto.request.CreateFavouritePetRequest;
import app.service.common.FavouritePetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favoritos")
public class FavouritesController {

    private final FavouritePetService favouritePetService;

    /*@GetMapping("/perros")
    public ResponseEntity<List<ItemDTO>> getFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouritePetService.getFavouriteItemsByUsername(user),HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<FavouritePetDTO> addFavouritePet(@RequestHeader("email") String email, @RequestBody @Valid CreateFavouritePetRequest request) {
        return ok(favouritePetService.save(email, request.getPetId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavouritePet(@PathVariable("id") Long id) {
        favouritePetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
