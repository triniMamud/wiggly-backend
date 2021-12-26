package app.controller;

import app.model.dto.MascotaDTO;
import app.service.intefaces.IGatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(path = "/gatos")
public class GatosController {

    @Autowired
    IGatoService gatoService;

    @GetMapping("/list")
    public ResponseEntity<List<MascotaDTO>> getGatosList() throws MessagingException {
        return new ResponseEntity<>(gatoService.getList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<MascotaDTO> postNewGato(@RequestBody MascotaDTO mascota) {
        return new ResponseEntity<>(gatoService.altaMascota(mascota), HttpStatus.OK);
    }

}
