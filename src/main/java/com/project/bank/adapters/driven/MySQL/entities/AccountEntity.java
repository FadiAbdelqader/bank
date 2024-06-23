package com.project.bank.adapters.driven.MySQL.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "accounts")
public record AccountEntity(
        @Id
        long id,

        double balance,

        String accountType,

        long overdraftAuth
) {
}
