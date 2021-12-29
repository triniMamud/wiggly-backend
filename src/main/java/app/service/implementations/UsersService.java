package app.service.implementations;

import app.mapper.UserMapper;
import app.model.Encryption;
import app.model.dto.AccountDTO;
import app.model.dto.UserDTO;
import app.model.entity.Account;
import app.repository.IAccountsRepository;
import app.repository.IUsersRepository;
import app.service.intefaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

    private IUsersRepository usuariosRepository;
    private IAccountsRepository accountsRepository;

    @Autowired
    public UsersService(IUsersRepository usuariosRepository, IAccountsRepository accountsRepository) {
        this.usuariosRepository = usuariosRepository;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public UserDTO altaUsuario(UserDTO usuario, String password) {
        if(!accountsRepository.existsAccountByUsuario(usuario.getUsuario())) {
            accountsRepository.save(new Account(usuario.getUsuario(), Encryption.encryptPssw(password)));
            usuariosRepository.save(UserMapper.newUsuario(usuario));
        }
        return usuario;
    }

    @Override
    public Void logIn(AccountDTO accountDTO) {
        if(accountsRepository.existsAccountByUsuario(accountDTO.getUsuario())) {
            Encryption.checkPassw(accountDTO.getPassword(), accountsRepository.getUserPssw(accountDTO.getUsuario()));
        }
        return null;
    }


}
