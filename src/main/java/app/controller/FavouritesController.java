package app.controller;

import app.model.dto.ItemDTO;
import app.service.intefaces.IFavouriteCatService;
import app.service.intefaces.IFavouriteDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
public class FavouritesController {

    private IFavouriteDogService favouriteDogService;
    private IFavouriteCatService favouriteCatService;

    @Autowired
    public FavouritesController(IFavouriteDogService favouriteDogService, IFavouriteCatService favouriteCatService) {
        this.favouriteDogService = favouriteDogService;
        this.favouriteCatService = favouriteCatService;
    }

    @GetMapping("/perros")
    public ResponseEntity<List<ItemDTO>> getFavouriteDogs(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteDogService.getFavouriteDogs(user),HttpStatus.OK);
    }

    @PostMapping("/perros/{idDog}")
    public ResponseEntity<Boolean> addFavouriteDog(@RequestHeader("user") String user, @PathVariable int idDog) throws Exception {
        return new ResponseEntity<>(favouriteDogService.addNewFavouriteDog(user, idDog), HttpStatus.OK);
    }

    @GetMapping("/gatos")
    public ResponseEntity<List<ItemDTO>> getFavouriteCats(@RequestHeader("user") String user) {
        return new ResponseEntity<>(favouriteCatService.getFavouriteCats(user),HttpStatus.OK);
    }

    @PostMapping("/gatos/{idCat}")
    public ResponseEntity<Boolean> addFavouriteCat(@RequestHeader("user") String user, @PathVariable int idCat) throws Exception {
        return new ResponseEntity<>(favouriteCatService.addNewFavouriteCat(user, idCat), HttpStatus.OK);
    }
}
