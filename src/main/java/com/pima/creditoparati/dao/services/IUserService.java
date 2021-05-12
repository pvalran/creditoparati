package com.Xoot.CreditoParaTi.models.dao.services;

import java.util.List;

import com.Xoot.CreditoParaTi.entity.User;

public interface IUserService {
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void delete(Long id);
	
	public User userLogin(String userName, String pass);
}
