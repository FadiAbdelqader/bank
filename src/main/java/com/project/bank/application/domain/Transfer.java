package com.project.bank.application.domain;

import java.time.LocalDateTime;

public record Transfer(
        long id,

        double amount,

        LocalDateTime date,

        long account_id
) {
}
