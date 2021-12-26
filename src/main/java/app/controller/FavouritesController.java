package app.controller;

import app.model.dto.ItemDTO;
import app.service.intefaces.IFavouriteGatoService;
import app.service.intefaces.IFavouritePerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavouritesController {

    @Autowired
    IFavouritePerroService favouritePerroService;
    @Autowired
    IFavouriteGatoService favouriteGatoService;

    @GetMapping("/perros")
    public ResponseEntity<List<ItemDTO>> getFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouritePerroService.getFavourites(user),HttpStatus.OK);
    }

    @PostMapping("/perros/{id_perro}")
    public ResponseEntity<Boolean> addFavouriteDog(@RequestHeader("user") String user, @PathVariable int id_perro) throws Exception {
        return new ResponseEntity<>(favouritePerroService.addNewFavourite(user, id_perro), HttpStatus.OK);
    }

    @GetMapping("/gatos")
    public ResponseEntity<List<ItemDTO>> getFavouriteCats(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteGatoService.getFavourites(user),HttpStatus.OK);
    }

    @PostMapping("/gatos/{id_gato}")
    public ResponseEntity<Boolean> addFavouriteCat(@RequestHeader("user") String user, @PathVariable int id_gato) throws Exception {
        return new ResponseEntity<>(favouriteGatoService.addNewFavourite(user, id_gato), HttpStatus.OK);
    }
}
