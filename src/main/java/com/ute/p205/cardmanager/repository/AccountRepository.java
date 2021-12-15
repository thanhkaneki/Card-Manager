package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByNumber(String number);
}
