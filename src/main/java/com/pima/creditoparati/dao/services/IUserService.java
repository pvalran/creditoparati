package com.pima.creditoparati.dao.services;

import com.pima.creditoparati.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(Integer id);

    public User save(User user);

    public void delete(Integer id);

    public User userLogin(String userName, String pass);

    public List<User> findAllActive();
}
