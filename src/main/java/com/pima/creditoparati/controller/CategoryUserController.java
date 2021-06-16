package com.pima.creditoparati.controller;

import com.pima.creditoparati.dao.services.ICategoryUserService;
import com.pima.creditoparati.entity.CategoryUser;
import com.pima.creditoparati.entity.DTO.CategoryUserDTO;
import com.pima.creditoparati.utilidades.ResponseDTO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"}) // Cross para angular
@RestController
@RequestMapping("/categoryUser")
public class CategoryUserController {

    @Autowired
    private ICategoryUserService CategoryUserService;
    private Object data;
    private String message;
    private Boolean result;

    /*
	 * Metodo para obtener todos las categorias de usuario
     */
    @GetMapping("/all")
    public ResponseDTO all() {
        try {
            data = CategoryUserService.findAll();
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
	 * Metodo para obtener una categoria de usuario
     */
    @GetMapping("/show/{id}")
    public ResponseDTO show(@PathVariable Integer id) {
        try {
            data = CategoryUserService.findById(id);
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
	 * Metodo para crear una categoria de usuario
     */
    @PostMapping("/create")
    public ResponseDTO create(@RequestBody CategoryUserDTO categoryUser) {
        try {
            CategoryUser catUser = new CategoryUser();
            catUser.setStatus_flag(1);
            catUser.setName(categoryUser.getName());

            data = CategoryUserService.save(catUser);
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
	 * Metodo para actualizar una categoria de usuario
     */
    @PutMapping("/update")
    public ResponseDTO update(@RequestBody CategoryUserDTO categoryUser) {
        try {
            CategoryUser CategoryUserActual = CategoryUserService.findById(categoryUser.getIdCategoryUser());
            CategoryUserActual.setName(categoryUser.getName());
            CategoryUserActual.setStatus_flag(1);
            CategoryUserActual.setMdfd_on(new Date());

            data = CategoryUserService.save(CategoryUserActual);
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
            CategoryUser catUser = CategoryUserService.findById(id);
            catUser.setStatus_flag(0);
            catUser.setMdfd_on(new Date());
            CategoryUserService.save(catUser);

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
	 * Metodo para obtener todos las categorias de usuario activos
     */
    @GetMapping("/allActive")
    public ResponseDTO allActive() {
        try {
            data = CategoryUserService.findAllActive();
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
