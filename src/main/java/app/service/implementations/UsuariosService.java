package app.service.implementations;

import app.mapper.UsuarioMapper;
import app.model.Encryption;
import app.model.dto.AccountDTO;
import app.model.dto.UsuarioDTO;
import app.model.entity.Account;
import app.repository.IAccountsRepository;
import app.repository.IUsuariosRepository;
import app.service.intefaces.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService {

    private IUsuariosRepository usuariosRepository;
    private IAccountsRepository accountsRepository;

    @Autowired
    public UsuariosService(IUsuariosRepository usuariosRepository, IAccountsRepository accountsRepository) {
        this.usuariosRepository = usuariosRepository;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public UsuarioDTO altaUsuario(UsuarioDTO usuario, String password) {
        if(!accountsRepository.existsAccountByUsuario(usuario.getUsuario())) {
            accountsRepository.save(new Account(usuario.getUsuario(), Encryption.encryptPssw(password)));
            usuariosRepository.save(UsuarioMapper.newUsuario(usuario));
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
