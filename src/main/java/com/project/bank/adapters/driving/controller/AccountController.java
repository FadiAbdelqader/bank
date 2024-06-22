package com.project.bank.adapters.driving.controller;

import com.project.bank.application.domain.Account;
import com.project.bank.application.dto.AccountDTO;
import com.project.bank.application.usecases.AccountUsecase;
import com.project.bank.infrastructure.exceptions.AccountAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountUsecase accountUsecase;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") int id) throws AccountNotFoundException {
        return accountUsecase.getAccountById(id);
    }

    @PostMapping
    public void createAccount(@RequestBody AccountDTO accountDTO) throws AccountAlreadyExistsException {
        accountUsecase.createAccount(accountDTO);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
    public void updateAccount(@PathVariable("id") long id, @RequestBody Map<String, Object> body) throws AccountNotFoundException {
        accountUsecase.manageOverdraft(id, body);
    }

    @RequestMapping(value = "/manage/{id}", method = RequestMethod.PATCH)
    public void manageBalance(@PathVariable("id") long id, @RequestBody Map<String, Object> body) throws AccountNotFoundException {
        accountUsecase.manageBalance(id, body);
    }
}
