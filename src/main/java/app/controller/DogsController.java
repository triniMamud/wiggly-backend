package app.controller;

import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.IMyDogsService;
import app.service.intefaces.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(path = "/perros")
public class DogsController {

    private IDogService perroService;
    private IMyDogsService myDogsService;

    @Autowired
    public DogsController(IDogService perroService, IMyDogsService myDogsService) {
        this.perroService = perroService;
        this.myDogsService = myDogsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PetDTOResponse>> getPerrosList() throws MessagingException {
        return new ResponseEntity<>(perroService.getList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PetDTOResponse> postNewPerro(@RequestBody PetDTORequest mascota, @RequestHeader("username") String username) throws Exception {
        myDogsService.addToMyDogs(mascota.getMascota().getId(), username);
        return new ResponseEntity<>(perroService.altaMascota(mascota), HttpStatus.OK);
    }
}
