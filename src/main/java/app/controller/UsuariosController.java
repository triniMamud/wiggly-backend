package app.controller;

import app.model.dto.UsuarioDTO;
import app.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;

    @PostMapping("/alta")
    public ResponseEntity<UsuarioDTO> altaUsuario(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity<>(usuariosService.altaUsuario(usuario), HttpStatus.OK);
    }
}
