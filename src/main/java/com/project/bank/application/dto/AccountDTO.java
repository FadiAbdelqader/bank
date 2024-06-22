package com.project.bank.application.dto;

public record AccountDTO (
        long id,

        double balance,

        boolean overdraft,

        long overdraftAuth
) {
}
