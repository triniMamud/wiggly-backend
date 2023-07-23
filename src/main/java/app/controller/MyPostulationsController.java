package app.controller;

import app.model.dto.ItemDTO;
import app.service.common.MyPostulationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/misPostulaciones")
public class MyPostulationsController {

    private final MyPostulationsService myPostulationsService;

    /*@GetMapping("/list")
    public ResponseEntity<List<ItemDTO>> getMyPostulations(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myPostulationsService.getMyPostulations(username), HttpStatus.OK);
    }*/

    @PostMapping("/{idPet}")
    public ResponseEntity<Boolean> addPostulation(@RequestHeader("email") String email, @PathVariable long idPet) {
        return new ResponseEntity<>(myPostulationsService.postulate(email, idPet), HttpStatus.OK);
    }
}
