package app.controller;

import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.IDogService;
import app.service.intefaces.IMyDogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<PetDTOResponse>> getDogList() throws Exception {
        return new ResponseEntity<>(dogService.getDogsList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PetDTOResponse> postNewDog(@RequestBody PetDTORequest pet, @RequestHeader("username") String username) throws Exception {
        PetDTOResponse petDTOResponse = dogService.addNewDog(pet);
        myDogsService.addToMyDogs(petDTOResponse.getPet().getId(), username);
        return new ResponseEntity<>(petDTOResponse, HttpStatus.OK);
    }

    @GetMapping("/list/{idPerro}")
    public ResponseEntity<PetDTOResponse> getDog(@PathVariable int idDog) {
        return new ResponseEntity<>(dogService.getDog(idDog), HttpStatus.OK);
    }
}
