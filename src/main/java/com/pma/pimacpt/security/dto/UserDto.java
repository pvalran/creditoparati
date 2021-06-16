package com.pma.pimacpt.security.dto;


import com.pma.pimacpt.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDto {
    @Autowired
    UserRepository userRepository;

    public boolean existUser(String userName){
        return userRepository.existsUserByUserName(userName);
    }
    public boolean existUserEmail(String userName){
        return userRepository.existsUserByEmail(userName);
    }
}
