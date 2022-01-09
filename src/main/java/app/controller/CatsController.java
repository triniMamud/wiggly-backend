package app.controller;

import app.model.dto.PetDTORequest;
import app.model.dto.PetDTOResponse;
import app.service.intefaces.ICatService;
import app.service.intefaces.IMyCatsService;
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
@RequestMapping(path = "/gatos")
public class CatsController {

    private ICatService catService;
    private IMyCatsService myCatsService;

    @Autowired
    public CatsController(ICatService catService, IMyCatsService myCatsService) {
        this.catService = catService;
        this.myCatsService = myCatsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<PetDTOResponse>> getCatList() throws Exception {
        return new ResponseEntity<>(catService.getCatsList(), HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<PetDTOResponse> postNewCat(@RequestBody PetDTORequest pet, @RequestHeader("username") String username) throws Exception {
        PetDTOResponse petDTOResponse = catService.addNewCat(pet);
        myCatsService.addToMyCats(petDTOResponse.getPet().getId(), username);
        return new ResponseEntity<>(petDTOResponse, HttpStatus.OK);
    }
}
