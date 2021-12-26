package app.controller;

import app.model.dto.ItemDTO;
import app.service.intefaces.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavouritesController {

    @Autowired
    IFavouriteService favouriteService;

    @GetMapping("/perros")
    public ResponseEntity<List<ItemDTO>> getFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteService.getFavouriteDogs(user),HttpStatus.OK);
    }

    @PostMapping("/perros/{id_perro}")
    public ResponseEntity<Boolean> addFavouriteDog(@RequestHeader("user") String user, @PathVariable int id_perro) {
        return new ResponseEntity<>(favouriteService.addNewFavouriteDog(user, id_perro), HttpStatus.OK);
    }

    @GetMapping("/gatos")
    public ResponseEntity<List<ItemDTO>> getFavouriteCats(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteService.getFavouriteCats(user),HttpStatus.OK);
    }

    @PostMapping("/gatos/{id_gato}")
    public ResponseEntity<Boolean> addFavouriteCat(@RequestHeader("user") String user, @PathVariable int id_gato) {
        return new ResponseEntity<>(favouriteService.addNewFavouriteCat(user, id_gato), HttpStatus.OK);
    }
}
