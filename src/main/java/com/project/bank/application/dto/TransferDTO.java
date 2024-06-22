package com.project.bank.application.dto;

import java.time.LocalDateTime;

public record TransferDTO (
        long id,

        double amount,

        LocalDateTime date,

        long account_id
) {
}
