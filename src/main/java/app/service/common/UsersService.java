package app.service.common;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.Encryption;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.entity.Account;
import app.model.entity.User;
import app.repository.IAccountRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static app.model.Encryption.encryptPssw;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class UsersService {

    private final IUserRepository userRepository;
    private final IAccountRepository accountRepository;
    private final ModelMapper mapper;


    public UserDTO logIn(AccountDTO accountDTO) throws WrongPasswordException, UserDoesntExistException {
        Account accountDB = accountRepository.findByEmail(accountDTO.getEmail());
        if (isEmpty(accountDB)) throw new UserDoesntExistException();
        else if (!BCrypt.checkpw(accountDTO.getPassword(), accountDB.getEncryptedPassword()))
            throw new WrongPasswordException();
        else
            return mapper.map(userRepository.findByEmail(accountDTO.getEmail()), UserDTO.class);
    }

    public boolean resetPassword(String email) throws UserDoesntExistException {
        Account accountDB = accountRepository.findByEmail(email);
        if (isEmpty(accountDB)) throw new UserDoesntExistException();
        return true; //HACER LOGICA
    }

    public UserDTO registerUser(User user, String password) throws UserAlreadyTakenException {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new UserAlreadyTakenException();

        user.setIsFormAnswered(false);
        userRepository.save(user);
        accountRepository.save(Account.builder().email(user.getEmail()).encryptedPassword(encryptPssw(password)).build());
        return new UserDTO(user.getName(), user.getEmail(), user.getIsFormAnswered(), user.getAdoptionType().name());
    }

    public boolean getIsFormAnswered(String email) {
        Boolean result = userRepository.getIsFormAnswered(email);
        return nonNull(result) && result;
    }
}
