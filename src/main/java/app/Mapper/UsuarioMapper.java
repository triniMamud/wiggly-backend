package app.Mapper;

import app.model.dto.UsuarioDTO;
import app.model.entity.Usuario;

public class UsuarioMapper {

    public static Usuario newUsuario(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.getId(),usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getEdad(),usuarioDTO.getBarrio(),
                usuarioDTO.getMailContacto(),usuarioDTO.getNumeroContacto(),usuarioDTO.getAdopta(),usuarioDTO.getTipoDomicilio(),
                usuarioDTO.getTienePatioOBalcon(),usuarioDTO.getTieneRedContencion(),usuarioDTO.getTieneOtrasMacotas(),usuarioDTO.getAclaracionOtrasMascotas(),usuarioDTO.getUsuario());
    }

    public static UsuarioDTO newUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),usuario.getNombre(),usuario.getApellido(),usuario.getEdad(),usuario.getBarrio(),
                usuario.getMailContacto(),usuario.getNumeroContacto(),usuario.getAdopta(),usuario.getTipoDomicilio(),
                usuario.getTienePatioOBalcon(),usuario.getTieneRedContencion(),usuario.getTieneOtrasMacotas(),usuario.getAclaracionOtrasMascotas(),usuario.getUsuario());
    }
}
