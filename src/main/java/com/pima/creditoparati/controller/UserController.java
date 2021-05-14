package com.pima.creditoparati.controller;

import com.pima.creditoparati.dao.services.ICategoryUserService;
import com.pima.creditoparati.dao.services.IUserService;
import com.pima.creditoparati.entity.CategoryUser;
import com.pima.creditoparati.entity.DTO.UserDTO;
import com.pima.creditoparati.entity.User;
import com.pima.creditoparati.security.Security;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})//Cross para angular
@RestController
@RequestMapping("/api")
public class UserController {
    //Implementacion de interfaz

    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryUserService categoryUserService;

    /*
    * Metodo para obtener todos los usuario
    * */
    @GetMapping("/UsersAll")
    public List<User> allUser() {
        return userService.findAll();
    }

    /*
    * Metodo para obtener un usuario por id
    * */
    @GetMapping("/UsersShow/{id}")
    public User showUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    /*
    * Metodo para crear un usuario
    * */
    @PostMapping("/UsersCreate")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserDTO user) {
        Security security = new Security();

        User newUser = new User();
        newUser.setActivo(1);
        newUser.setDtCreate(new Date());
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(security.getAES(user.getPassword()));
        newUser.setDtLastLogin(null);

        CategoryUser objCatUser = categoryUserService.findById(user.getIdCategory());

        newUser.setCategoryUser(objCatUser);

        return userService.save(newUser);
    }

    /*
    * Metodo para actualizar un usuario por Id
    * */
    @PutMapping("/UsersUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody UserDTO user) {
        User UserActual = userService.findById(user.getIdUser());
        UserActual.setUserName(user.getUserName());
        UserActual.setEmail(user.getEmail());
        UserActual.setPassword(user.getPassword());
        UserActual.setDtModify(new Date());

        CategoryUser objCatUser = categoryUserService.findById(user.getIdCategory());

        UserActual.setCategoryUser(objCatUser);

        return userService.save(UserActual);
    }

    /*
    * Metodo para borrado logico de un usuario por Id
    * */
    @GetMapping("/UsersDelete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        User userActual = userService.findById(id);
        userActual.setActivo(0);
        userService.save(userActual);
    }

    /*
    * Metodo para obtener un usuario activo por Contraseña y UserName
    * */
    @PostMapping("/Login")
    public User Login(@RequestBody UserDTO user) {
        Security security = new Security();

        return userService.userLogin(user.getUserName(), security.getAES(user.getPassword()));
    }

    /*
    * Metodo para obtener todos los usuarios activos
    * */
    @GetMapping("/UsersAllActive")
    public List<User> usersActive() {
        return userService.findAllActive();
    }
}
