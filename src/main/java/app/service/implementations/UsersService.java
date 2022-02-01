package app.service.implementations;

import app.exception.types.UserAlreadyTakenException;
import app.exception.types.UserDoesntExistException;
import app.exception.types.WrongUserOrPasswordException;
import app.model.Encryption;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.entity.Account;
import app.model.entity.User;
import app.repository.IAccountsRepository;
import app.repository.IUsersRepository;
import app.service.intefaces.IUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

    private final IUsersRepository usuariosRepository;
    private final IAccountsRepository accountsRepository;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public UsersService(IUsersRepository usuariosRepository, IAccountsRepository accountsRepository) {
        this.usuariosRepository = usuariosRepository;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public UserDTO signUpUser(UserDTO userDTO, String password) throws UserAlreadyTakenException {
        if(!accountsRepository.existsAccountByUsername(userDTO.getUsername())) {
            userDTO.setAccountId(accountsRepository.save(new Account(userDTO.getUsername(), Encryption.encryptPssw(password))).getId());
            usuariosRepository.save(mapper.map(userDTO, User.class));
        }
        else {
            throw new UserAlreadyTakenException();
        }
        return userDTO;
    }

    @Override
    public Void logIn(AccountDTO accountDTO) throws WrongUserOrPasswordException, UserDoesntExistException {
        if(accountsRepository.existsAccountByUsername(accountDTO.getUser())) {
            if(!Encryption.checkPassw(accountDTO.getPassword(), accountsRepository.getUserPassword(accountDTO.getUser()))) {
                throw new WrongUserOrPasswordException();
            }
        }
        else {
            throw new UserDoesntExistException();
        }
        return null;
    }


}
