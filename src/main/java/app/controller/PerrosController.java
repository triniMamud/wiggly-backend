package app.controller;

import app.model.dto.MascotaDTO;
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

    @Autowired
    IPerroService perroService;

    @GetMapping("/list")
    public ResponseEntity<List<MascotaDTO>> getPerrosList() throws MessagingException {
        return new ResponseEntity<>(perroService.getList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<MascotaDTO> postNewPerro(@RequestBody MascotaDTO mascota) {
        return new ResponseEntity<>(perroService.altaMascota(mascota), HttpStatus.OK);
    }
}
