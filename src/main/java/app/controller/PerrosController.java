package app.controller;

import app.model.dto.MascotaDTO;
import app.service.intefaces.IMyDogsService;
import app.service.intefaces.IPerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(path = "/perros")
public class PerrosController {

    private IPerroService perroService;
    private IMyDogsService myDogsService;

    @Autowired
    public PerrosController(IPerroService perroService, IMyDogsService myDogsService) {
        this.perroService = perroService;
        this.myDogsService = myDogsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MascotaDTO>> getPerrosList() throws MessagingException {
        return new ResponseEntity<>(perroService.getPerrosList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<MascotaDTO> postNewPerro(@RequestBody MascotaDTO mascota, @RequestHeader("username") String username) throws Exception {
        myDogsService.addToMyDogs(mascota.getId(), username);
        return new ResponseEntity<>(perroService.altaPerro(mascota), HttpStatus.OK);
    }
}
