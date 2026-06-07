package app.service.common;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.dto.request.RegisterRequest;
import app.model.dto.request.UpdateProfilePhotoRequestDTO;
import app.model.dto.response.CloackUserResponse;
import app.model.entity.Account;
import app.model.entity.User;
import app.repository.IAccountRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static app.model.Encryption.encryptPssw;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class UsersService {

    private final IUserRepository userRepository;
    private final IAccountRepository accountRepository;
    private final ModelMapper mapper;


    public CloackUserResponse logIn(AccountDTO accountDTO) throws WrongPasswordException, UserDoesntExistException {
        String emailLower = accountDTO.getEmail().toLowerCase();
        Account accountDB = accountRepository.findByEmail(accountDTO.getEmail());

        if (isEmpty(accountDB)) throw new UserDoesntExistException();
        if (!BCrypt.checkpw(accountDTO.getPassword(), accountDB.getEncryptedPassword()))
            throw new WrongPasswordException();

        CloackUserResponse response = mapper.map(
                userRepository.findByEmail(emailLower).orElseThrow(UserDoesntExistException::new),
                CloackUserResponse.class
        );
        response.setFormAnswered(getIsFormAnswered(emailLower));

        return response;
    }

    public boolean resetPassword(String email) throws UserDoesntExistException {
        Account accountDB = accountRepository.findByEmail(email);
        if (isEmpty(accountDB)) throw new UserDoesntExistException();
        return true; //HACER LOGICA
    }

    public User registerUser(RegisterRequest request, String password) throws UserAlreadyTakenException, UnderAgeException {
        String emailLower = request.getEmail().toLowerCase();

        if (userRepository.findByEmail(emailLower).isPresent())
            throw new UserAlreadyTakenException();

        if (request.getBirthDate().plusYears(18).isAfter(LocalDate.now()))
            throw new UnderAgeException();

        User userEntity = mapper.map(request, User.class);
        userEntity.setEmail(emailLower);
        userEntity.setIsFormAnswered(false);

        if (request.getProfilePhoto() != null && !request.getProfilePhoto().isEmpty()) {
            userEntity.setProfilePhoto("data:image;base64," + request.getProfilePhoto());
        }

        userRepository.save(userEntity);

        accountRepository.save(
                Account.builder()
                        .email(emailLower)
                        .encryptedPassword(encryptPssw(password))
                        .build()
        );

        return userEntity;
    }

    public boolean getIsFormAnswered(String email) {
        Boolean result = userRepository.getIsFormAnswered(email);
        return nonNull(result) && result;
    }

    public UserDTO updateProfilePhoto(String email, UpdateProfilePhotoRequestDTO request) throws UserDoesntExistException {
        User userDB = userRepository.findByEmail(email).orElseThrow(UserDoesntExistException::new);
        String profilePhoto = "data:image;base64,"+ request.getProfilePhoto();
        userRepository.updateProfilePhoto(email, profilePhoto);

        return new UserDTO();
    }

    public Optional<String> getShelterNameByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .map(User::getShelterName);
    }
}
