package com.pima.creditoparati.dao.services;

import com.pima.creditoparati.entity.CategoryUser;

import java.util.List;

public interface ICategoryUserService {
	public List<CategoryUser> findAll();
	
	public CategoryUser findById(Long id);
	
	public CategoryUser save(CategoryUser categoryUser);
	
	public void delete(Long id);
}
