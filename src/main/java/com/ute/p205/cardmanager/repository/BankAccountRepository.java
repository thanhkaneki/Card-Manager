package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    BankAccount findByNumber(String number);
}
