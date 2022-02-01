package app.controller;

import app.model.dto.AdoptantDTO;
import app.model.dto.ItemDTO;
import app.model.dto.PetDTO;
import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.ICatService;
import app.service.intefaces.IDogService;
import app.service.intefaces.IMyCatsService;
import app.service.intefaces.IMyDogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyPetsController {

    private IMyDogsService myDogsService;
    private IDogService dogService;
    private IMyCatsService myCatsService;
    private ICatService catService;

    @Autowired
    public MyPetsController (IMyDogsService myDogsService, IDogService dogService, IMyCatsService myCatsService, ICatService catService) {
        this.myDogsService = myDogsService;
        this.dogService = dogService;
        this.myCatsService = myCatsService;
        this.catService = catService;
    }

    @GetMapping("/misPerros")
    public ResponseEntity<List<ItemDTO>> getMyDogs(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myDogsService.getMyDogs(username), HttpStatus.OK);
    }

    @PostMapping("/misPerros/{idDog}/editar")
    public ResponseEntity<PetDTOResponse> editMyDogs(@PathVariable("idDog") int idDog, @RequestBody PetDTORequest petRequest) throws Exception {
        return new ResponseEntity<>(dogService.editDog(idDog, petRequest), HttpStatus.OK);
    }

    @GetMapping("/misPerros/{idDog}/postulantes")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsDog(@PathVariable("idDog") int idDog) {
        return new ResponseEntity<>(myDogsService.getAdoptantsDog(idDog), HttpStatus.OK);
    }

    @GetMapping("/misGatos")
    public ResponseEntity<List<ItemDTO>> getMyCats(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myCatsService.getMyCats(username), HttpStatus.OK);
    }

    @PostMapping("/misGatos/{idCat}/editar")
    public ResponseEntity<PetDTOResponse> editMyCats(@PathVariable("idCat") int idCat, @RequestBody PetDTORequest petRequest) throws Exception {
        return new ResponseEntity<>(catService.editCat(idCat, petRequest), HttpStatus.OK);
    }

    @GetMapping("/misGatos/{idCat}/postulantes")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsCat(@PathVariable("idCat") int idCat) {
        return new ResponseEntity<>(myCatsService.getAdoptantsCat(idCat), HttpStatus.OK);
    }
}
