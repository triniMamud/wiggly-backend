package app.controller;

import app.model.dto.AccountDTO;
import app.model.dto.UsuarioDTO;
import app.service.intefaces.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;

    @PostMapping("/log_in")
    public ResponseEntity<Void> login(@RequestBody AccountDTO account) {
        return new ResponseEntity<>(usuariosService.logIn(account),HttpStatus.OK);
    }

    @PostMapping("/alta")
    public ResponseEntity<UsuarioDTO> altaUsuario(@RequestBody UsuarioDTO usuario, @RequestHeader("password") String password) {
        return new ResponseEntity<>(usuariosService.altaUsuario(usuario, password), HttpStatus.OK);
    }
}
