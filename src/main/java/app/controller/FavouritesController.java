package app.controller;

import app.model.dto.ItemDogDTO;
import app.service.IFavouriteService;
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

    @GetMapping
    public ResponseEntity<List<ItemDogDTO>> gerFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteService.getFavouriteDogs(user),HttpStatus.OK);
    }

    @PostMapping("/{id_perro}")
    public ResponseEntity<Boolean> addFavourite(@RequestHeader("user") String user, @PathVariable int id_perro) {
        return new ResponseEntity<>(favouriteService.addNewFavourite(user, id_perro), HttpStatus.OK);
    }
}
