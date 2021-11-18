package com.ute.p205.cardmanager.config;

import com.ute.p205.cardmanager.model.Role;
import com.ute.p205.cardmanager.model.Status;
import com.ute.p205.cardmanager.model.Type;
import com.ute.p205.cardmanager.model.User;
import com.ute.p205.cardmanager.repository.RoleRepository;
import com.ute.p205.cardmanager.repository.StatusRepository;
import com.ute.p205.cardmanager.repository.TypeRepository;
import com.ute.p205.cardmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class DataSeedingListener implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TypeRepository typeRepository;
    @Override
    public void run(String...args) throws Exception{
        List<Type> l = typeRepository.findAll();
        l.forEach(x -> System.out.println(x.getName()) );
        // Role
        if (roleRepository.findByRole("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (roleRepository.findByRole("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        if(statusRepository.findByStatus("block") == null){
            statusRepository.save(new Status("block"));
        }
        if(statusRepository.findByStatus("active") == null){
            statusRepository.save(new Status("active"));
        }
        // Admin account
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRole("ROLE_ADMIN"));
            roles.add(roleRepository.findByRole("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

    }
}