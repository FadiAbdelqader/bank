package com.project.bank.adapters.driving.controller;

import com.project.bank.application.dto.TransferDTO;
import com.project.bank.application.usecases.TransferUsecases;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/transfers")
public class TransferController {

    private final TransferUsecases transferUsecases;

    @PostMapping
    public void transfer(@RequestBody TransferDTO transferDTO) throws AccountNotFoundException {
        if(transferDTO.amount() > 0) {
            transferUsecases.deposit(transferDTO);
        } else {
            transferUsecases.withdraw(transferDTO);
        }
    }
}
