package com.ute.p205.cardmanager.config;

import com.ute.p205.cardmanager.model.BankAccount;
import com.ute.p205.cardmanager.model.SysAccount;
import com.ute.p205.cardmanager.model.SysRole;
import com.ute.p205.cardmanager.model.SysStatus;
import com.ute.p205.cardmanager.repository.BankAccountRepository;
import com.ute.p205.cardmanager.repository.SysRoleRepository;
import com.ute.p205.cardmanager.repository.SysAccountRepository;

import com.ute.p205.cardmanager.repository.SysStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class DataSeedingListener implements CommandLineRunner {
    @Autowired
    private SysAccountRepository sysAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysStatusRepository sysStatusRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        // Role
        if (sysRoleRepository.findByRole("ROLE_ADMIN") == null) {
            sysRoleRepository.save(new SysRole("ROLE_ADMIN"));
        }
        if (sysRoleRepository.findByRole("ROLE_MEMBER") == null) {
            sysRoleRepository.save(new SysRole("ROLE_MEMBER"));
        }
        if (sysStatusRepository.findByStatus("block") == null) {
            sysStatusRepository.save(new SysStatus("block"));
        }
        if (sysStatusRepository.findByStatus("active") == null) {
            sysStatusRepository.save(new SysStatus("active"));
        }

        // Admin account
        if (sysAccountRepository.findByUsername("admin") == null) {
            SysAccount admin = new SysAccount();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            HashSet<SysRole> roles = new HashSet<>();
            roles.add(sysRoleRepository.findByRole("ROLE_ADMIN"));
            roles.add(sysRoleRepository.findByRole("ROLE_MEMBER"));
            admin.setSysRoles(roles);
            SysStatus sysStatus = sysStatusRepository.findByStatus("active");
            admin.setSysStatus(sysStatus);
            sysAccountRepository.save(admin);
        }
        if  (bankAccountRepository.findByNumber("123456789") == null){
            BankAccount bankAccount = new BankAccount("123456789");
            SysAccount sysAccount = sysAccountRepository.findByUsername("admin");
            bankAccount.setSysAccount(sysAccount);
            bankAccountRepository.save(bankAccount);
        }
    }
}