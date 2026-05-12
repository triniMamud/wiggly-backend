package app.controller;

import app.model.ApiResponse;
import app.model.dto.FavouritePetDTO;
import app.model.dto.ItemDTO;
import app.model.dto.request.CreateFavouritePetRequest;
import app.model.dto.response.PetAdoptionResponseDTO;
import app.model.dto.response.PetDTOResponse;
import app.service.common.FavouritePetService;
import com.google.protobuf.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

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
    public ResponseEntity<Void> deleteFavouritePet(@RequestHeader("email") String email, @PathVariable("id") Long id) {
        favouritePetService.delete(email, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PetDTOResponse>> getFavouritePetByUser(@RequestHeader("email") String email) {
        try {
            return ok(favouritePetService.getFavouritePetByUser(email));
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }
    }
}
