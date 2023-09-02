package app.service.common;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.entity.Account;
import app.repository.IAccountRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class UsersService {

    private final IUserRepository userRepository;
    private final IAccountRepository accountRepository;
    private final ModelMapper mapper;


    public UserDTO signUpUser(UserDTO userDTO, String password) throws UserAlreadyTakenException, UnderAgeException {
        if(userDTO.getAge() < 13) {
            throw new UnderAgeException();
        }
//        if(!accountsRepository.existsAccountByUsername(userDTO.getUsername())) {
//           // userDTO.setAccountId(accountsRepository.save(new Account(userDTO.getUsername(), Encryption.encryptPssw(password))).getId());
//            usuariosRepository.save(mapper.map(userDTO, User.class));
//        }
        else {
            throw new UserAlreadyTakenException();
        }
  //      return userDTO;
    }

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
}
