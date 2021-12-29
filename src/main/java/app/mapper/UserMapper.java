package app.mapper;

import app.model.dto.UserDTO;
import app.model.entity.User;

public class UserMapper {

    public static User castToUser(UserDTO userDTO) {
        return new User(
                userDTO.getUsername(), userDTO.getName(), userDTO.getLastName(), userDTO.getAge(), userDTO.getNeighbourhood(),
                userDTO.getMail(), userDTO.getPhone(), userDTO.getAdopts(), userDTO.getHouseType(),
                userDTO.getHasGardenOrBalcony(), userDTO.getHasContentionNet(), userDTO.getHasAnotherPets(), userDTO.getOtherPetsInfo());
    }

    public static UserDTO castToUserDTO(User user) {
        return new UserDTO(
                user.getUsername(), user.getName(), user.getLastName(), user.getAge(), user.getNeighbourhood(),
                user.getMail(), user.getPhone(), user.getAdopts(), user.getHouseType(),
                user.getHasGardenOrBalcony(), user.getHasContentionNet(), user.getHasAnotherPets(), user.getOtherPetsInfo());
    }
}
