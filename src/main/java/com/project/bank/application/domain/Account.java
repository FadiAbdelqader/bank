package com.project.bank.application.domain;

public record Account(
        long id,

        double balance,

        boolean overdraft,

        long overdraftAuth
) {
}
