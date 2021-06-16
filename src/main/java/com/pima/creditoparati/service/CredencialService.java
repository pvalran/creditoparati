/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pima.creditoparati.service;

import com.pima.creditoparati.model.user.CategoryUser;
import com.pima.creditoparati.model.user.User;
import com.pima.creditoparati.repository.CategoryInterface;
import com.pima.creditoparati.repository.UserInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author super
 */
@Service
public class CredencialService {
    
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private CategoryInterface categoryInterface;
    
    public boolean creteUser(User user){
        userInterface.save(user);
        return true;
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
}
