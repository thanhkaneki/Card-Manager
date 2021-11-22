package com.ute.p205.cardmanager.config;

<<<<<<< HEAD
import com.ute.p205.cardmanager.model.SysAccount;
import com.ute.p205.cardmanager.model.SysRole;
import com.ute.p205.cardmanager.repository.SysRoleRepository;
import com.ute.p205.cardmanager.repository.SysAccountRepository;
=======
import com.ute.p205.cardmanager.model.Role;
import com.ute.p205.cardmanager.model.Status;
import com.ute.p205.cardmanager.model.Type;
import com.ute.p205.cardmanager.model.User;
import com.ute.p205.cardmanager.repository.RoleRepository;
import com.ute.p205.cardmanager.repository.StatusRepository;
import com.ute.p205.cardmanager.repository.TypeRepository;
import com.ute.p205.cardmanager.repository.UserRepository;
>>>>>>> 7823849fd3f0bfc8dfb366b3eb867d9b0398aefd
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
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TypeRepository typeRepository;
    @Override
    public void run(String...args) throws Exception{
<<<<<<< HEAD
        // Roles

        if (sysRoleRepository.findByRole("ROLE_ADMIN") == null) {
            sysRoleRepository.save(new SysRole("ROLE_ADMIN"));
=======
        List<Type> l = typeRepository.findAll();
        l.forEach(x -> System.out.println(x.getName()) );
        // Role
        if (roleRepository.findByRole("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
>>>>>>> 7823849fd3f0bfc8dfb366b3eb867d9b0398aefd
        }
        if (sysRoleRepository.findByRole("ROLE_MEMBER") == null) {
            sysRoleRepository.save(new SysRole("ROLE_MEMBER"));
        }
        if(statusRepository.findByStatus("block") == null){
            statusRepository.save(new Status("block"));
        }
        if(statusRepository.findByStatus("active") == null){
            statusRepository.save(new Status("active"));
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