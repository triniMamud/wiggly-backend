package app.service.implementations;

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

    private ModelMapper mapper;

    @Autowired
    public UsersService(IUsersRepository usuariosRepository, IAccountsRepository accountsRepository) {
        this.usuariosRepository = usuariosRepository;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public UserDTO signUpUser(UserDTO userDTO, String password) {
        if(!accountsRepository.existsAccountByUsername(userDTO.getUsername())) {
            accountsRepository.save(new Account(userDTO.getUsername(), Encryption.encryptPssw(password)));
            usuariosRepository.save(mapper.map(userDTO, User.class));
        }
        return userDTO;
    }

    @Override
    public Void logIn(AccountDTO accountDTO) {
        if(accountsRepository.existsAccountByUsername(accountDTO.getUser())) {
            Encryption.checkPassw(accountDTO.getPassword(), accountsRepository.getUserPassword(accountDTO.getUser()));
        }
        return null;
    }


}
