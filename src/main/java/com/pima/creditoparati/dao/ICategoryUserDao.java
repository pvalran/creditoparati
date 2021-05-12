package com.pima.creditoparati.dao;

import org.springframework.data.repository.CrudRepository;

import com.pima.creditoparati.entity.CategoryUser;

public interface ICategoryUserDao extends CrudRepository<CategoryUser, Long> {

}
