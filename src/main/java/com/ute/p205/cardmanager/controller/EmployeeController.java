package com.ute.p205.cardmanager.controller;
import com.ute.p205.cardmanager.model.*;
import com.ute.p205.cardmanager.repository.CustomerInfoRepository;
import com.ute.p205.cardmanager.repository.CustomerRepository;
import com.ute.p205.cardmanager.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class EmployeeController {
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerInfoRepository customerInfoRepository;
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
    public String Wellcome(){ return "home";}
}