package app.service.common;

import app.exception.types.UnderAgeException;
import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongPasswordException;
import app.model.Encryption;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
//import app.model.entity.Account;
import app.model.entity.User;
//import app.repository.IAccountRepository;
import app.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final IUserRepository usuariosRepository;
  //  private final IAccountRepository accountsRepository;
    private final ModelMapper modelMapper;


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

    public Void logIn(AccountDTO accountDTO) throws WrongPasswordException, UserDoesntExistException {
//        if(accountsRepository.existsAccountByUsername(accountDTO.getUser())) {
//            if(!Encryption.checkPassw(accountDTO.getPassword(), accountsRepository.getUserPassword(accountDTO.getUser()))) {
//                throw new WrongPasswordException();
//            }
//        }
//        else {
//            throw new UserDoesntExistException();
//        }
        return null;
    }
}
