package com.pima.creditoparati.dao.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pima.creditoparati.dao.ICategoryUserDao;
import com.pima.creditoparati.entity.CategoryUser;

@Service
public class CategoryUserImpl implements ICategoryUserService {

    @Autowired
    private ICategoryUserDao categoryUserDao;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryUser> findAll() {
        return (List<CategoryUser>) categoryUserDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryUser findById(Long id) {
        return categoryUserDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public CategoryUser save(CategoryUser CategoryUser) {
        return categoryUserDao.save(CategoryUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryUserDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryUser> findAllActive() {
        return categoryUserDao.findAllActive();
    }
}
