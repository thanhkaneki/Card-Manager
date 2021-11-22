package com.ute.p205.cardmanager.repository;

import com.ute.p205.cardmanager.model.SysAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAccountRepository extends JpaRepository<SysAccount, Long> {
    SysAccount findByUsername(String username);
}
