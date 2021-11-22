package com.ute.p205.cardmanager.service;

import com.ute.p205.cardmanager.model.SysAccount;
import com.ute.p205.cardmanager.model.SysAccountDTO;
import com.ute.p205.cardmanager.model.SysRole;
import com.ute.p205.cardmanager.repository.SysAccountRepository;
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
    SysAccountRepository sysAccountRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        SysAccount acc = sysAccountRepository.findByUsername(username);
        if(acc == null){
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<SysRole> roles = acc.getSysRoles();

        return new org.springframework.security.core.userdetails.User(
                acc.getUsername(), acc.getPassword(), grantedAuthorities
        );
    }
    public SysAccount save(SysAccountDTO user) {
        SysAccount newUser = new SysAccount();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return sysAccountRepository.save(newUser);
    }
}
