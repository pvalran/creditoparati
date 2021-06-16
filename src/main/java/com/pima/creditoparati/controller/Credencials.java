/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pima.creditoparati.controller;

import com.pima.creditoparati.model.user.CategoryUser;
import com.pima.creditoparati.model.user.User;
import com.pima.creditoparati.service.CredencialService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author super
 */
@RestController
@RequestMapping("credencial")
public class Credencials {
    
    @Autowired
    private CredencialService service;
    
    @PostMapping("/addUser")
    public String creteUser(@Valid @RequestBody User user){
        
        return "si";
    }
    
    @GetMapping("/getCategory")
    public List<CategoryUser> getCategory(@RequestParam(required = false) int id){
        return service.getCategory(id);
    }
}
