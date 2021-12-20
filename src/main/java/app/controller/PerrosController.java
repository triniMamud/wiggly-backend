package app.controller;

import app.model.dto.PerroDtoResponse;
import app.service.IPerrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/perros")
public class PerrosController {

    @Autowired
    IPerrosService perrosService;

    @GetMapping("/list")
    public ResponseEntity<List<PerroDtoResponse>> getPerrosList() {
        return new ResponseEntity<>(perrosService.getPerrosList(), HttpStatus.OK);
    }
}
