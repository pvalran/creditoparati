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

import com.Xoot.CreditoParaTi.Security;
import com.Xoot.CreditoParaTi.entity.CategoryUser;
import com.Xoot.CreditoParaTi.entity.User;
import com.Xoot.CreditoParaTi.entity.DTO.UserDTO;
import com.Xoot.CreditoParaTi.models.dao.services.ICategoryUserService;
import com.Xoot.CreditoParaTi.models.dao.services.IUserService;

@CrossOrigin(origins= {"http://localhost:4200"})//Cross para angular
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private IUserService userService;
	//private ICategoryUserService categoryUserService;
	
	@GetMapping("/Users")
	public List<User> index(){
		return userService.findAll();
	}
	
	@GetMapping("/Users/{id}")
	public User show(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/Users")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody UserDTO user) {
		Security security = new Security();
		
		User newUser = new User();
		newUser.setActivo(1);
		newUser.setDtCreate(new Date());
		newUser.setUserName(user.getUserName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(security.getAES(user.getPassword()));
		newUser.setDtLastLogin(null);
		
		//CategoryUser catUser = categoryUserService.findById(user.getIdCategory());
		
		//newUser.setCategoryUser(catUser);
		return userService.save(newUser);
	}
	
	@PutMapping("/Users/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User update(@RequestBody UserDTO user, @PathVariable Long id) {
		User UserActual= userService.findById(id);
		UserActual.setUserName(user.getUserName());
		UserActual.setEmail(user.getEmail());
		UserActual.setPassword(user.getPassword());
		UserActual.setDtModify(new Date());
		
		return userService.save(UserActual);
	}
	
	@DeleteMapping("/Users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
	
	@PostMapping("/Login")
	public User Login(@RequestBody UserDTO user) {
		Security security = new Security();
		
		return userService.userLogin(user.getUserName(), security.getAES(user.getPassword()));
		
	}
}
