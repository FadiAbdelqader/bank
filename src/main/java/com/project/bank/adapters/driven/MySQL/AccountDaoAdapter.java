package com.project.bank.adapters.driven.MySQL;

import com.project.bank.adapters.driven.MySQL.entities.AccountEntity;
import com.project.bank.adapters.driven.MySQL.repositories.AccountRepository;
import com.project.bank.application.domain.Account;
import com.project.bank.application.dto.AccountDTO;
import com.project.bank.application.dao.AccountDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class AccountDaoAdapter implements AccountDAO {

    private final AccountRepository accountRepository;
    @Override
    public Account getAccountById(long id) {
        AccountEntity accountEntity = (accountRepository.findById(id)).orElse(null);
        return new Account(accountEntity.id(),accountEntity.balance(), accountEntity.overdraft(), accountEntity.overdraftAuth());
    }

    @Override
    public void createAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity(accountDTO.id(),accountDTO.balance(),accountDTO.overdraft(),accountDTO.overdraftAuth());
        accountRepository.save(accountEntity);
    }

    @Override
    public void manageOverdraft(long id, Map<String, Object> body) {
        boolean overdraft = (boolean) body.get("overdraft");
        double overdraft_auth = (double) body.get("overdraftAuth");
        accountRepository.manageOverdraft(id, overdraft, overdraft_auth);
    }

    @Override
    public void manageBalance(long id, double newBalance) {
        accountRepository.manageBalance(id, newBalance);
    }
}
