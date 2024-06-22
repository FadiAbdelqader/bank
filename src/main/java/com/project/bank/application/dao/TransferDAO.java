package com.project.bank.application.dao;

import com.project.bank.application.dto.TransferDTO;

public interface TransferDAO {
    void transfer(TransferDTO transferDTO);
}
