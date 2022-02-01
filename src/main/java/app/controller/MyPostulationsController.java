package app.controller;

import app.model.dto.ItemDTO;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.IDogService;
import app.service.intefaces.IMyDogsService;
import app.service.intefaces.IMyPostulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/mis-postulaciones")
public class MyPostulationsController {

    private IMyPostulationsService myPostulationsService;

    @Autowired
    public MyPostulationsController(IMyPostulationsService myPostulationsService, IMyDogsService myDogsService) {
        this.myPostulationsService = myPostulationsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> getMyPostulations(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myPostulationsService.getMyPostulations(username), HttpStatus.OK);
    }
}
