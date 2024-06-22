package com.project.bank.application.usecases;

import com.project.bank.application.domain.Account;
import com.project.bank.application.dto.TransferDTO;
import com.project.bank.application.dao.TransferDAO;
import com.project.bank.infrastructure.exceptions.OverdraftExceededException;
import com.project.bank.infrastructure.exceptions.OverdraftNotAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@RequiredArgsConstructor
@Service
public class TransferUsecases {

    private final TransferDAO transferDAO;
    private final AccountUsecase accountUsecase;

    public void deposit(TransferDTO transferDTO) throws AccountNotFoundException {
        transferDAO.transfer(transferDTO);
    }

    public void withdraw(TransferDTO transferDTO) throws AccountNotFoundException {
        try {
            Account account = accountUsecase.getAccountById((int) transferDTO.account_id());
            double balance = account.balance();
            double withdrawAmount = transferDTO.amount();
            if(balance + withdrawAmount < 0 && account.overdraft()){
                if(Math.abs(balance + withdrawAmount) > Math.abs(account.overdraftAuth()) ) {
                    throw new OverdraftExceededException("Overdraft exceeded.");
                } else {
                    transferDAO.transfer(transferDTO);
                }
            } else if (balance + withdrawAmount < 0 && !account.overdraft()) {
                throw new OverdraftNotAuthorizedException("Overdraft not authorized.");
            } else {
                transferDAO.transfer(transferDTO);
            }
        } catch (AccountNotFoundException e) {
            throw new AccountNotFoundException("Account not found");
        }
    }
}
