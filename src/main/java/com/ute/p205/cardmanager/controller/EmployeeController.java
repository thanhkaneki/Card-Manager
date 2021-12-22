package com.ute.p205.cardmanager.controller;
import com.ute.p205.cardmanager.config.DataSeedingListener;
import com.ute.p205.cardmanager.model.*;
import com.ute.p205.cardmanager.repository.*;
import com.ute.p205.cardmanager.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

@RestController
@CrossOrigin()
public class EmployeeController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CustomerStatusRepository CustomerStatusRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountStatusRepository accountStatusRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardTypeRepository cardTypeRepository;
    @Autowired
    private CardStatusRepository cardStatusRepository;
    @Autowired
    private LimitCreditCardRepository limitCreditCardRepository;

    @Autowired
    private TypeOfMoneyRepository typeOfMoneyRepository;

    
//    @Autowired
//    private JwtUserDetailsService userDetailsService;
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private CustomerInfoRepository customerInfoRepository;
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    public ResponseEntity<CustomerInfoDTO> getInfoUser(@RequestBody CustomerDTO customerDTO) throws Exception {
        final Customer customer = customerRepository.findByUsername(customerDTO.getUsername());
        final CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO(customer.getCustomerInfo());
        System.out.println(customerInfoDTO.toString());
        return ResponseEntity.ok(new CustomerInfoDTO(customer.getCustomerInfo()));
    }
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getEmployees() {
        return "Welcome!";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Wellcome() throws Exception{
        System.out.println("Connection!!");
        return "home";
    }

}