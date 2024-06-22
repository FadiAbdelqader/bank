package com.project.bank.adapters.driven.MySQL.repositories;

import com.project.bank.adapters.driven.MySQL.entities.TransferEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TransferRepository extends CrudRepository<TransferEntity,Long> {

    @Modifying
    @Query("update transfers t set t.amount = :amount, t.date = :date, t.account_id = :accountId where t.id = :id")
    void deposit(@Param("id") long id, double amount, LocalDateTime date, long accountId);

    @Modifying
    @Query("update transfers t set t.amount = :amount, t.date = :date where t.id = :id")
    void withdraw(@Param("id") long id, double amount, LocalDateTime date);

    //@Query("update accounts a set a.overdraft = :overdraft, a.overdraft_auth = :overdraft_auth where a.id = :accountId")

}
