package app.controller;

import app.model.dto.PerroDTO;
import app.service.IPerrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/perros")
public class PerrosController {

    @Autowired
    IPerrosService perrosService;

    @GetMapping("/list")
    public ResponseEntity<List<PerroDTO>> getPerrosList() {
        return new ResponseEntity<>(perrosService.getPerrosList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PerroDTO> postNewPerro(@RequestBody PerroDTO mascota) {
        return new ResponseEntity<>(perrosService.altaPerro(mascota), HttpStatus.OK);
    }
}
