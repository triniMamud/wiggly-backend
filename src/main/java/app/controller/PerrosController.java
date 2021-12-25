package app.controller;

import app.model.dto.MascotaDTO;
import app.model.MascotasEnum;
import app.service.IMascotasService;
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
    IMascotasService mascotasService;

    @GetMapping("/list")
    public ResponseEntity<List<MascotaDTO>> getPerrosList() throws MessagingException {
        return new ResponseEntity<>(mascotasService.getList(MascotasEnum.PERRO), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<MascotaDTO> postNewPerro(@RequestBody MascotaDTO mascota) {
        return new ResponseEntity<>(mascotasService.altaMascota(mascota, MascotasEnum.PERRO), HttpStatus.OK);
    }
}
