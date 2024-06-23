package com.project.bank.application.dto;

public record AccountDTO (
        long id,

        double balance,

        String accountType,

        long overdraftAuth
) {
}
