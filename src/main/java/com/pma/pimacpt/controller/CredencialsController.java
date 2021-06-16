/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pma.pimacpt.controller;

import java.util.List;
import javax.validation.Valid;

import com.pma.pimacpt.dto.Respuesta;
import com.pma.pimacpt.model.user.CategoryUser;
import com.pma.pimacpt.model.user.User;
import com.pma.pimacpt.security.dto.LoginCredencials;
import com.pma.pimacpt.security.dto.UserDto;
import com.pma.pimacpt.security.jwt.JwtProvider;
import com.pma.pimacpt.security.model.UserLoginModel;
import com.pma.pimacpt.service.user.CredencialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author super
 */
@RestController
@RequestMapping("/credencial")
@CrossOrigin
public class CredencialsController {
    
    @Autowired
    private CredencialService service;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDto userDto;

    @PostMapping("/addUser")
    public ResponseEntity<?> creteUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Respuesta(
                    "Error agregando usuario: " + bindingResult.getNestedPath() + " ",
                    false,
                    null
            ), HttpStatus.BAD_REQUEST);
        }
        try {
            if (userDto.existUser(user.getUserName())) {
                return new ResponseEntity(new Respuesta(
                        "User registered previously",
                        false,
                        null
                ), HttpStatus.BAD_REQUEST);
            }
            if (userDto.existUserEmail(user.getEmail())) {
                return new ResponseEntity(new Respuesta(
                        "Email registered previously",
                        false,
                        null
                ), HttpStatus.BAD_REQUEST);
            }
            if (service.creteUser(user)) {
                return new ResponseEntity(new Respuesta(
                        "Success user added correctly",
                        true,
                        null
                ), HttpStatus.CREATED);
            }
        }
        catch (Exception e){
            LOGGER.error("ERROR GeNERANDO usuario 74 "+e.getMessage(),e.getCause());
            return new ResponseEntity(new Respuesta(
                    "ERROR adding user "+e,
                    false,
                    e.fillInStackTrace()
            ), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(new Respuesta(
                "Bad Gateway",
                false,
                null
        ), HttpStatus.BAD_GATEWAY);
    }
    
    @GetMapping("/getCategory")
    public ResponseEntity<?> getCategory(@RequestParam(required = false, defaultValue = "0") Integer id){
        List<CategoryUser> categoryUsers= service.getCategory(id);
        if(categoryUsers!=null&&!categoryUsers.isEmpty()) {
            return new ResponseEntity(new Respuesta(
                    "Category",
                    true,
                    categoryUsers
            ), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(new Respuesta(
                    "No category",
                    false,
                    null
            ), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginModel login, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Respuesta(
                    "You have some errors: " + bindingResult.getNestedPath() + " ",
                    false,
                    null
            ), HttpStatus.BAD_REQUEST);
        }
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUser(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            LoginCredencials loginCredencials = new LoginCredencials(token, userDetails.getUsername(), userDetails.getAuthorities());
            service.updateLoginDate(userDetails);
            return new ResponseEntity(new Respuesta(
                    "You are logged",
                    true,
                    loginCredencials
            ), HttpStatus.OK);
        }
        catch (AuthenticationException e){
            return new ResponseEntity(new Respuesta(
                    "Credentials are incorrect",
                    false,
                    e.getMessage()
            ), HttpStatus.UNAUTHORIZED);
        }
    }

    private final static Logger LOGGER= LoggerFactory.getLogger(CredencialService.class);
}
