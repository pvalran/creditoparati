/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pma.pimacpt.service.user;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pma.pimacpt.model.user.CategoryUser;
import com.pma.pimacpt.model.user.User;
import com.pma.pimacpt.repository.user.CategoryInterface;
import com.pma.pimacpt.repository.user.UserRepository;
import com.pma.pimacpt.security.model.UserCredencial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author super
 */
@Service
@Transactional
public class CredencialService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryInterface categoryInterface;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public boolean creteUser(User user){
        user.setLastLogin(new Timestamp(Instant.now().toEpochMilli()));
        user.setPass(passwordEncoder.encode(user.getPass()));
        user.setActivo(true);
        User resp=userRepository.save(user);
        return user.getEmail().equals(resp.getEmail()) && user.getUserName().equals(resp.getUserName());
    }
    
    public List<CategoryUser> getCategory(int category){
        if(category==0){
            return categoryInterface.findAll();
        }
        else{
            List<CategoryUser> resp=new ArrayList<>();
            categoryInterface.findById(category).ifPresent(resp::add);
            return resp;
        }
    }

    public Optional<User> getUserByName(String userName){
        return userRepository.findByUserName(userName);
    }

    public void updateLoginDate(UserDetails userDetails){
        User user=getUserByName(userDetails.getUsername()).get();
        user.setLastLogin(new Timestamp(Instant.now().toEpochMilli()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, UsernameNotFoundException {
        User user= userRepository.findByUserName(userName).get();
        UserDetails userDetails= UserCredencial.build(user);
        /*new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPass(),
                authoritiesRoles(user.getCategoryUser())
        );*/
        return userDetails;
    }

    public List<GrantedAuthority> authoritiesRoles(CategoryUser categoryUser){
        List<GrantedAuthority> roles=new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(categoryUser.getNameCategory()));
        return roles;
    }
}
