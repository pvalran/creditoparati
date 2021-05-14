package com.pima.creditoparati.controller;

import com.pima.creditoparati.dao.services.ICategoryUserService;
import com.pima.creditoparati.entity.CategoryUser;
import com.pima.creditoparati.entity.DTO.CategoryUserDTO;

import java.util.Date;
import java.util.List;
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

@CrossOrigin(origins = {"http://localhost:4200"})//Cross para angular
@RestController
@RequestMapping("/api")
public class CategoryUserController {

    @Autowired
    private ICategoryUserService CategoryUserService;

    /*
    * Metodo para obtener todos las categorias de usuario
    * */
    @GetMapping("/categoryUsersAll")
    public List<CategoryUser> index() {
        return CategoryUserService.findAll();
    }

    /*
	 * Metodo para obtener una categoria de usuario
	 * */
    @GetMapping("/categoryUsersShow/{id}")
    public CategoryUser show(@PathVariable Long id) {
        return CategoryUserService.findById(id);
    }

    /*
    * Metodo para crear una categoria de usuario
    * */
    @PostMapping("/categoryUsersCreate")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryUser create(@RequestBody CategoryUserDTO categoryUser) {
        CategoryUser catUser = new CategoryUser();
        catUser.setActivo(1);
        catUser.setDtCreate(new Date());
        catUser.setName(categoryUser.getName());
        return CategoryUserService.save(catUser);
    }

    /*
    * Metodo para actualizar una categoria de usuario
    * */
    @PutMapping("/categoryUsersUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryUser update(@RequestBody CategoryUserDTO categoryUser) {
        CategoryUser CategoryUserActual = CategoryUserService.findById(categoryUser.getIdCategory());
        CategoryUserActual.setName(categoryUser.getName());
        CategoryUserActual.setActivo(1);
        CategoryUserActual.setDtModify(new Date());

        return CategoryUserService.save(CategoryUserActual);
    }

    /*
    * Metodo para borrado logico de un usuario por Id
    * */
    @GetMapping("/CategoryUsersDelete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        CategoryUser catUser = CategoryUserService.findById(id);
        catUser.setActivo(0);
        CategoryUserService.save(catUser);
    }

    /*
    * Metodo para obtener todos las categorias de usuario activos
    * */
    @GetMapping("/CategoryUsersAllActive")
    public List<CategoryUser> usersActive() {
        return CategoryUserService.findAllActive();
    }
}
