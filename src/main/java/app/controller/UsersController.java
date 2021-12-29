package app.controller;

import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.service.intefaces.IUsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    private IUsersService usuariosService;

    public UsersController(IUsersService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping("/log_in")
    public ResponseEntity<Void> login(@RequestBody AccountDTO account) {
        return new ResponseEntity<>(usuariosService.logIn(account),HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<UserDTO> altaUsuario(@RequestBody UserDTO usuario, @RequestHeader("password") String password) {
        return new ResponseEntity<>(usuariosService.altaUsuario(usuario, password), HttpStatus.OK);
    }
}
