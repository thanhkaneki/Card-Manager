package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {
    AccountStatus findByName(String name);
}
