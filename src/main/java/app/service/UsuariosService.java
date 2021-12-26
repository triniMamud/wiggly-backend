package app.service;

import app.mapper.UsuarioMapper;
import app.model.dto.UsuarioDTO;
import app.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    IUsuariosRepository usuariosRepository;

    @Override
    public UsuarioDTO altaUsuario(UsuarioDTO usuario) {
        usuariosRepository.save(UsuarioMapper.newUsuario(usuario));
        return usuario;
    }
}
