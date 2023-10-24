package app.controller;

import app.model.dto.ItemDTO;
import app.model.dto.UserFullDTO;
import app.service.common.MyPostulationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/misPostulaciones")
public class MyPostulationsController {

    private final MyPostulationsService myPostulationsService;

    /*@GetMapping
    public ResponseEntity<List<ItemDTO>> getMyPostulations(@RequestHeader("username") String username) {
        return new ResponseEntity<>(myPostulationsService.getMyPostulations(username), HttpStatus.OK);
    }*/

    @GetMapping("/{petId}")
    public ResponseEntity<List<UserFullDTO>> getMyPostulations(@PathVariable(name = "petId") Long petId) {
        try {
            return ok(myPostulationsService.getUsersPetMyPostulations(petId));
        } catch (Exception e) {
            return status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{idPet}")
    public ResponseEntity<Boolean> addPostulation(@RequestHeader("email") String email, @PathVariable long idPet) {
        return new ResponseEntity<>(myPostulationsService.postulate(email, idPet), HttpStatus.OK);
    }
}
