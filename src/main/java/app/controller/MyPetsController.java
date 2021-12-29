package app.controller;

import app.model.dto.ItemDTO;
import app.model.dto.PetDTO;
import app.model.dto.AdoptantDTO;
import app.service.intefaces.ICatService;
import app.service.intefaces.IMyCatsService;
import app.service.intefaces.IMyDogsService;
import app.service.intefaces.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyPetsController {

    private IMyDogsService myDogsService;
    private IDogService perroService;
    private IMyCatsService myCatsService;
    private ICatService gatosService;

    @Autowired
    public MyPetsController (IMyDogsService myDogsService, IDogService perroService, IMyCatsService myCatsService, ICatService gatosService) {
        this.myDogsService = myDogsService;
        this.perroService = perroService;
        this.myCatsService = myCatsService;
        this.gatosService = gatosService;
    }

    @PostMapping("/misPerros")
    public ResponseEntity<List<ItemDTO>> getMyDogs(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myDogsService.getMyDogs(username), HttpStatus.OK);
    }

    @PostMapping("/misPerros/editar/{idPerro}")
    public ResponseEntity<PetDTO> editMyDogs(@PathVariable("idPerro") int idPerro, @RequestBody PetDTO mascota) throws Exception {
        return new ResponseEntity<>(perroService.editPerro(idPerro, mascota), HttpStatus.OK);
    }

    @PostMapping("/misPerros/postulantes/{idPerro}")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsDog(@PathVariable("idPerro") int idPerro) {
        return new ResponseEntity<>(myDogsService.getAdoptantsDog(idPerro), HttpStatus.OK);
    }

    @PostMapping("/misGatos")
    public ResponseEntity<List<ItemDTO>> getMyCats(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myCatsService.getMyCats(username), HttpStatus.OK);
    }

    @PostMapping("/misGatos/editar/{idCat}")
    public ResponseEntity<PetDTO> editMyCats(@PathVariable("idCat") int idCat, @RequestBody PetDTO mascota) throws Exception {
        return new ResponseEntity<>(gatosService.editCat(idCat, mascota), HttpStatus.OK);
    }

    @PostMapping("/misGatos/postulantes/{idCat}")
    public ResponseEntity<List<AdoptantDTO>> getAdoptantsCat(@PathVariable("idCat") int idCat) {
        return new ResponseEntity<>(myCatsService.getAdoptantsCat(idCat), HttpStatus.OK);
    }
}
