package com.project.bank.adapters.driven.MySQL.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name="transfers")
public record TransferEntity(
        @Id
        long id,

        double amount,

        LocalDateTime date,

        long account_id
) {
}
