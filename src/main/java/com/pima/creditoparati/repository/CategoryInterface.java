/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pima.creditoparati.repository;

import com.pima.creditoparati.model.user.CategoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author super
 */
@Repository
public interface CategoryInterface extends JpaRepository<CategoryUser, Integer>{
    
}
