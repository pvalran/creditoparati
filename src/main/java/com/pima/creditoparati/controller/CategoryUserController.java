package com.Xoot.CreditoParaTi.controllers;

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

import com.Xoot.CreditoParaTi.entity.CategoryUser;
import com.Xoot.CreditoParaTi.entity.DTO.CategoryUserDTO;
import com.Xoot.CreditoParaTi.models.dao.services.ICategoryUserService;


@CrossOrigin(origins= {"http://localhost:4200"})//Cross para angular
@RestController
@RequestMapping("/api")
public class CategoryUserController {
	@Autowired
	private ICategoryUserService CategoryUserService;
	
	@GetMapping("/categoryUsers")
	public List<CategoryUser> index(){
		return CategoryUserService.findAll();
	}
	
	@GetMapping("/categoryUsers/{id}")
	public CategoryUser show(@PathVariable Long id) {
		return CategoryUserService.findById(id);
	}
	
	@PostMapping("/categoryUsers")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryUser create(@RequestBody CategoryUserDTO categoryUser) {
		CategoryUser catUser = new CategoryUser();
		catUser.setActivo(1);
		catUser.setDtCreate(new Date());
		catUser.setName(categoryUser.getName());
		return CategoryUserService.save(catUser);
	}
	
	
	@PutMapping("/categoryUsers/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryUser update(@RequestBody CategoryUserDTO categoryUser, @PathVariable Long id) {
		CategoryUser CategoryUserActual= CategoryUserService.findById(id);
		CategoryUserActual.setName(categoryUser.getName());
		CategoryUserActual.setActivo(categoryUser.getActivo());
		CategoryUserActual.setDtModify(new Date());
		
		return CategoryUserService.save(CategoryUserActual);
	}
	
	@DeleteMapping("/CategoryUsers/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		CategoryUserService.delete(id);
	}
}
