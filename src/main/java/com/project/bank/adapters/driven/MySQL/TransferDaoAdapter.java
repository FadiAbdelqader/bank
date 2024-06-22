package com.project.bank.adapters.driven.MySQL;

import com.project.bank.adapters.driven.MySQL.entities.AccountEntity;
import com.project.bank.adapters.driven.MySQL.entities.TransferEntity;
import com.project.bank.adapters.driven.MySQL.repositories.AccountRepository;
import com.project.bank.adapters.driven.MySQL.repositories.TransferRepository;
import com.project.bank.application.dto.TransferDTO;
import com.project.bank.application.dao.TransferDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TransferDaoAdapter implements TransferDAO {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Override
    public void transfer(TransferDTO transferDTO) {
        LocalDateTime date = LocalDateTime.now();
        TransferEntity transferEntity = new TransferEntity(transferDTO.id(),transferDTO.amount(),date,transferDTO.account_id());
        transferRepository.save(transferEntity);
        Optional<AccountEntity> accountEntity = accountRepository.findById(transferDTO.account_id());
        double balance = 0;
        if(accountEntity.isPresent()) {
            balance = accountEntity.get().balance();
        }
        accountRepository.manageBalance(transferDTO.account_id(), balance + transferDTO.amount());
    }
}
