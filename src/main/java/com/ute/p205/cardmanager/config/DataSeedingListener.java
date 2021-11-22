package com.ute.p205.cardmanager.config;

import com.ute.p205.cardmanager.model.SysAccount;
import com.ute.p205.cardmanager.model.SysRole;
import com.ute.p205.cardmanager.repository.SysRoleRepository;
import com.ute.p205.cardmanager.repository.SysAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements CommandLineRunner {
    @Autowired
    private SysAccountRepository sysAccountRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception{
        // Roles

        if (sysRoleRepository.findByRole("ROLE_ADMIN") == null) {
            sysRoleRepository.save(new SysRole("ROLE_ADMIN"));
        }
        if (sysRoleRepository.findByRole("ROLE_MEMBER") == null) {
            sysRoleRepository.save(new SysRole("ROLE_MEMBER"));
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
            sysAccountRepository.save(admin);
        }
    }
}