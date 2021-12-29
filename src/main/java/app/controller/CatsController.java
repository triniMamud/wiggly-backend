package app.controller;

import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(path = "/gatos")
public class CatsController {

    private ICatService catService;

    @Autowired
    public CatsController(ICatService catService) {
        this.catService = catService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PetDTOResponse>> getCatList() throws MessagingException {
        return new ResponseEntity<>(catService.getCatsList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PetDTOResponse> postNewCat(@RequestBody PetDTORequest pet) throws Exception {
        return new ResponseEntity<>(catService.addNewCat(pet), HttpStatus.OK);
    }
}
