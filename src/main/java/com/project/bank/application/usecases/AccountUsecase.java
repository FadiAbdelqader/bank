package com.project.bank.application.usecases;

import com.project.bank.application.domain.Account;
import com.project.bank.application.dto.AccountDTO;
import com.project.bank.application.dao.AccountDAO;
import com.project.bank.infrastructure.exceptions.AccountAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccountUsecase {

    private final AccountDAO accountDAO;

    public void createAccount(AccountDTO accountDTO) throws AccountAlreadyExistsException {
        /*
        System.out.println("dto : " + accountDTO.id());
        if(accountDAO.getAccountById(accountDTO.id()) != null){
            throw new AccountAlreadyExistsException("Account already exists");
        } else {
            System.out.println("dans le else");
            accountDAO.createAccount(accountDTO);
        }
        */

        accountDAO.createAccount(accountDTO);
    }

    public void manageOverdraft(long id, Map<String,Object> body) throws AccountNotFoundException {
        Account acc = accountDAO.getAccountById(id);
        if(acc == null){
            throw new AccountNotFoundException("Account not found");
        }
        accountDAO.manageOverdraft(id,body);
    }

    public void manageBalance(long id, Map<String,Object> body) throws AccountNotFoundException {
        try {
            Account acc = accountDAO.getAccountById(id);
            double balance = acc.balance();
            double newBalance = balance + (double) body.get("amount");
            accountDAO.manageBalance(id,newBalance);
        } catch (Exception e){
            throw new AccountNotFoundException("Account not found");
        }
    }

    public Account getAccountById(int id) throws AccountNotFoundException {
        if (accountDAO.getAccountById(id) == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return accountDAO.getAccountById(id);
    }

}
