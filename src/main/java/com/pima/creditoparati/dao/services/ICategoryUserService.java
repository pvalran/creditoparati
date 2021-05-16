package com.pima.creditoparati.dao.services;

import com.pima.creditoparati.entity.CategoryUser;

import java.util.List;

public interface ICategoryUserService {

    public List<CategoryUser> findAll();

    public CategoryUser findById(Integer id);

    public CategoryUser save(CategoryUser categoryUser);

    public void delete(Integer id);

    public List<CategoryUser> findAllActive();
}
