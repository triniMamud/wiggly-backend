package app.controller;

import app.model.dto.ItemDTO;
import app.model.dto.MascotaDTO;
import app.model.dto.PostulantesDTO;
import app.service.intefaces.IGatoService;
import app.service.intefaces.IMyCatsService;
import app.service.intefaces.IMyDogsService;
import app.service.intefaces.IPerroService;
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

    @Autowired
    IMyDogsService myDogsService;
    @Autowired
    IPerroService perroService;
    @Autowired
    IMyCatsService myCatsService;
    @Autowired
    IGatoService gatosService;

    @PostMapping("/misPerros")
    public ResponseEntity<List<ItemDTO>> getMyDogs(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myDogsService.getMyDogs(username), HttpStatus.OK);
    }

    @PostMapping("/misPerros/editar/{idPerro}")
    public ResponseEntity<MascotaDTO> editMyDogs(@PathVariable("idPerro") int idPerro, @RequestBody MascotaDTO mascota) throws Exception {
        return new ResponseEntity<>(perroService.editPerro(idPerro, mascota), HttpStatus.OK);
    }

    @PostMapping("/misPerros/postulantes/{idPerro}")
    public ResponseEntity<List<PostulantesDTO>> getAdoptantsDog(@PathVariable("idPerro") int idPerro) {
        return new ResponseEntity<>(myDogsService.getAdoptantsDog(idPerro), HttpStatus.OK);
    }

    @PostMapping("/misGatos")
    public ResponseEntity<List<ItemDTO>> getMyCats(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myCatsService.getMyCats(username), HttpStatus.OK);
    }

    @PostMapping("/misGatos/editar/{idCat}")
    public ResponseEntity<MascotaDTO> editMyCats(@PathVariable("idCat") int idCat, @RequestBody MascotaDTO mascota) throws Exception {
        return new ResponseEntity<>(gatosService.editCat(idCat, mascota), HttpStatus.OK);
    }

    @PostMapping("/misGatos/postulantes/{idCat}")
    public ResponseEntity<List<PostulantesDTO>> getAdoptantsCat(@PathVariable("idCat") int idCat) {
        return new ResponseEntity<>(myCatsService.getAdoptantsCat(idCat), HttpStatus.OK);
    }
}
