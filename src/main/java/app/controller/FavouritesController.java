package app.controller;

import app.service.common.FavouritePetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favoritos")
public class FavouritesController {

    private final FavouritePetService favouritePetService;

    /*@GetMapping("/perros")
    public ResponseEntity<List<ItemDTO>> getFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouritePetService.getFavouriteItemsByUsername(user),HttpStatus.OK);
    }*/

    @PostMapping("/{idPet}")
    public ResponseEntity<Boolean> addFavouritePet(@RequestHeader("email") String email, @PathVariable long idPet) {
        return new ResponseEntity<>(favouritePetService.addFavouritePet(email, idPet), OK);
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> deleteFavouritePet(@RequestHeader("email") String email, @PathVariable long idPet) {
        favouritePetService.deleteFavouritePet(email, idPet);
        return new ResponseEntity<>(OK);
    }
}
