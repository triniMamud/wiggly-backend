package app.controller;

import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.IDogService;
import app.service.intefaces.IMyDogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/perros")
public class DogsController {

    private IDogService dogService;
    private IMyDogsService myDogsService;

    @Autowired
    public DogsController(IDogService dogService, IMyDogsService myDogsService) {
        this.dogService = dogService;
        this.myDogsService = myDogsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PetDTOResponse>> getPerrosList() throws Exception {
        return new ResponseEntity<>(dogService.getDogsList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PetDTOResponse> postNewPerro(@RequestBody PetDTORequest pet, @RequestHeader("username") String username) throws Exception {
        myDogsService.addToMyDogs(pet.getPet().getId(), username);
        return new ResponseEntity<>(dogService.addNewDog(pet), HttpStatus.OK);
    }
}
