package com.ute.p205.cardmanager.service;

import com.ute.p205.cardmanager.model.Customer;
import com.ute.p205.cardmanager.model.CustomerDTO;
import com.ute.p205.cardmanager.model.Role;
import com.ute.p205.cardmanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    CustomerRepository CustomerRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Customer acc = CustomerRepository.findByUsername(username);
        if(acc == null){
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = acc.getSysRoles();

        return new org.springframework.security.core.userdetails.User(
                acc.getUsername(), acc.getPassword(), grantedAuthorities
        );
    }
    public Customer save(CustomerDTO user) {
        Customer newUser = new Customer();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return CustomerRepository.save(newUser);
    }
}
