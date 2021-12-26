package app.service;

import app.model.dto.AccountDTO;
import app.model.dto.UsuarioDTO;

public interface IUsuariosService {
    UsuarioDTO altaUsuario(UsuarioDTO usuario,String password);
    Void logIn(AccountDTO accountDTO);
}
