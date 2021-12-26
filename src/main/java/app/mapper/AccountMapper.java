package app.Mapper;

import app.model.dto.AccountDTO;
import app.model.entity.Account;

public class AccountMapper {

    public static Account newAccount(AccountDTO accountDTO) {
        return new Account(accountDTO.getUsuario(), accountDTO.getPassword());
    }

    public static AccountDTO newAccountDTO(Account account) {
        return new AccountDTO(account.getUsuario(), account.getPassword());
    }
}
