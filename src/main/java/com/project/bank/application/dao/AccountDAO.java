package com.project.bank.application.dao;

import com.project.bank.application.domain.Account;
import com.project.bank.application.dto.AccountDTO;

import java.util.Map;

public interface AccountDAO {
    Account getAccountById(long id);
    void createAccount(AccountDTO accountDTO);
    void manageOverdraft(long id, Map<String, Object> body);
    void manageBalance(long id, double newBalance);
}
