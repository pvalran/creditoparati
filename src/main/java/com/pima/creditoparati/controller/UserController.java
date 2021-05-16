package com.pima.creditoparati.controller;

import com.pima.creditoparati.dao.services.ICategoryUserService;
import com.pima.creditoparati.dao.services.IUserService;
import com.pima.creditoparati.entity.CategoryUser;
import com.pima.creditoparati.entity.DTO.UserDTO;
import com.pima.creditoparati.entity.User;
import com.pima.creditoparati.utilidades.ResponseDTO;
import com.pima.creditoparati.utilidades.Security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"}) // Cross para angular
@RestController
@RequestMapping("/user")
public class UserController {
    // Implementacion de interfaz

    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryUserService categoryUserService;
    private Object data;
    private String message;
    private Boolean result;

    /*
	 * Metodo para obtener todos los usuario
     */
    @GetMapping("/all")
    public ResponseDTO all() {
        try {
            data = userService.findAll();
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para obtener un usuario por id
     */
    @GetMapping("/show/{id}")
    public ResponseDTO show(@PathVariable Integer id) {
        try {
            // Se desencripta la contraseña para mostrarlo
            Security security = new Security();
            User usuario = userService.findById(id);
            String Password = security.getAESDecrypt(usuario.getPassword());
            usuario.setPassword(Password);
            data = usuario;
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para crear un usuario
     */
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO create(@RequestBody UserDTO user) {
        try {
            Security security = new Security();

            User newUser = new User();
            newUser.setStatus_flag(1);
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(security.getAES(user.getPassword()));
            newUser.setDtLastLogin(null);

            CategoryUser objCatUser = categoryUserService.findById(user.getIdCategory());

            newUser.setCategoryUser(objCatUser);

            data = userService.save(newUser);
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para actualizar un usuario por Id
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO update(@RequestBody UserDTO user) {
        try {
            Security security = new Security();
            CategoryUser objCatUser = categoryUserService.findById(user.getIdCategory());

            User userActual = userService.findById(user.getIdUser());
            userActual.setUsername(user.getUsername());
            userActual.setEmail(user.getEmail());
            userActual.setPassword(security.getAES(user.getPassword()));
            userActual.setCategoryUser(objCatUser);
            userActual.setMdfd_on(new Date());

            data = userService.save(userActual);
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para borrado logico de un usuario por Id
     */
    @GetMapping("/delete/{id}")
    public ResponseDTO delete(@PathVariable Integer id) {
        try {
            User userActual = userService.findById(id);
            userActual.setStatus_flag(0);
            userActual.setMdfd_on(new Date());
            userService.save(userActual);

            data = null;
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para obtener todos los usuarios activos
     */
    @GetMapping("/allActive")
    public ResponseDTO allActive() {
        try {
            data = userService.findAllActive();
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }

    /*
	 * Metodo para obtener un usuario activo por Contraseña y UserName
     */
    @PostMapping("/login")
    public ResponseDTO Login(@RequestBody UserDTO user) {
        try {
            Security security = new Security();
            data = userService.userLogin(user.getUsername(), security.getAES(user.getPassword()));
            result = true;
            message = "Exito";
        } catch (Exception e) {
            data = null;
            result = false;
            message = e.getMessage();
        }
        return new ResponseDTO(data, message, result);
    }
}
