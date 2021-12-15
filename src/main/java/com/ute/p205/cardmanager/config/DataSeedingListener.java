package com.ute.p205.cardmanager.config;

import com.ute.p205.cardmanager.model.*;
import com.ute.p205.cardmanager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;

@Component
public class DataSeedingListener implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerStatusRepository CustomerStatusRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Date date;

    @Override
    public void run(String... args) throws Exception {
        // Role
        if (roleRepository.findByRole("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (roleRepository.findByRole("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        // Customer Status
        if (CustomerStatusRepository.findByStatus("block") == null) {
            CustomerStatusRepository.save(new CustomerStatus("block"));
        }
        if (CustomerStatusRepository.findByStatus("active") == null) {
            CustomerStatusRepository.save(new CustomerStatus("active"));
        }

        // Admin account
        if (customerRepository.findByUsername("admin") == null) {
            Customer admin = new Customer();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRole("ROLE_ADMIN"));
            roles.add(roleRepository.findByRole("ROLE_MEMBER"));
            admin.setSysRoles(roles);
            CustomerStatus customerStatus = CustomerStatusRepository.findByStatus("active");
            admin.setCustomerStatus(customerStatus);
            customerRepository.save(admin);
        }
        /*if  (accountRepository.findByNumber("123456789") == null){
            Account bankAccount = new Account("123456789");
            Customer Customer = CustomerRepository.findByUsername("admin");
            bankAccount.setCustomer(Customer);
            long time = System.currentTimeMillis();
            date = new Date(time);
            bankAccount.setOpenDate(date);
            accountRepository.save(bankAccount);
        }
        if  (accountRepository.findByNumber("987654321") == null){
            Account bankAccount = new Account("987654321");
            long time = System.currentTimeMillis();
            date = new Date(time);
            bankAccount.setOpenDate(date);
            accountRepository.save(bankAccount);
        }
        if  (accountRepository.findByNumber("789879798") == null){
            Account bankAccount = new Account("789879798");
            long time = System.currentTimeMillis();
            date = new Date(time);
            bankAccount.setOpenDate(date);
            accountRepository.save(bankAccount);
        }*/
    }
}