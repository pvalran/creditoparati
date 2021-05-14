package com.pima.creditoparati.dao;

import org.springframework.data.repository.CrudRepository;

import com.pima.creditoparati.entity.CategoryUser;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryUserDao extends CrudRepository<CategoryUser, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM creditoparati.category_user WHERE activo = 1;")
    List<CategoryUser> findAllActive();
}
