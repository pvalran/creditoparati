package com.pima.creditoparati.dao.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pima.creditoparati.dao.IUserDao;
import com.pima.creditoparati.entity.User;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User userLogin(String userName, String pass) {
        return (User) userDao.findByLogin(userName, pass);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllActive() {
        return userDao.findAllActive();
    }
}
