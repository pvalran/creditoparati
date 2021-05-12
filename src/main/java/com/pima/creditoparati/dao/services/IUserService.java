package com.pima.creditoparati.dao.services;

import com.pima.creditoparati.entity.User;

import java.util.List;

public interface IUserService {
	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
	
	public void delete(Long id);
	
	public User userLogin(String userName, String pass);
}
