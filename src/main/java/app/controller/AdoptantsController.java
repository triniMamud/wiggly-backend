package app.controller;

import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;
import app.service.common.AdoptantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adoptantes")
public class AdoptantsController {

    private final AdoptantService adoptantService;


    /*@GetMapping("/{idDog}")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsByPet(@PathVariable int idPet) {
        return new ResponseEntity<>(adoptantService.getAdoptantsByPet(idPet), HttpStatus.OK);
    }*/
}
