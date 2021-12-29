package app.mapper;

import app.model.dto.UserDTO;
import app.model.entity.User;

public class UserMapper {

    public static User newUsuario(UserDTO userDTO) {
        return new User(
                userDTO.getUsuario(), userDTO.getNombre(), userDTO.getApellido(), userDTO.getEdad(), userDTO.getBarrio(),
                userDTO.getMailContacto(), userDTO.getNumeroContacto(), userDTO.getAdopta(), userDTO.getTipoDomicilio(),
                userDTO.getTienePatioOBalcon(), userDTO.getTieneRedContencion(), userDTO.getTieneOtrasMacotas(), userDTO.getAclaracionOtrasMascotas());
    }

    public static UserDTO newUsuarioDTO(User user) {
        return new UserDTO(
                user.getUsuario(), user.getNombre(), user.getApellido(), user.getEdad(), user.getBarrio(),
                user.getMailContacto(), user.getNumeroContacto(), user.getAdopta(), user.getTipoDomicilio(),
                user.getTienePatioOBalcon(), user.getTieneRedContencion(), user.getTieneOtrasMacotas(), user.getAclaracionOtrasMascotas());
    }
}
