package com.project.bank.adapters.driven.MySQL.repositories;

import com.project.bank.adapters.driven.MySQL.entities.AccountEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends CrudRepository<AccountEntity,Long> {

    @Modifying
    @Query("update accounts a set a.overdraft_auth = :overdraft_auth where a.id = :accountId")
    void manageOverdraft(@Param("accountId") long id, double overdraft_auth);

    @Modifying
    @Query("update accounts a set a.balance = :newBalance where a.id = :accountId")
    void manageBalance(@Param("accountId") long id, double newBalance);

}
