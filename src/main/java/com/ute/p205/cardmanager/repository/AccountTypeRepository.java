package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
    AccountType findByName(String name);
}




