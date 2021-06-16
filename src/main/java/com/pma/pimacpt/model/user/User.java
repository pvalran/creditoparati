/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pma.pimacpt.model.user;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Type;

/**
 *
 * @author super
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user",unique = true)
    private int idUser;
    @Column(name = "user_name",length = 16,nullable = false)
    private String userName;
    @Column(name = "password", length = 255)
    private String pass;
    @Email
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "create_time",insertable = false, updatable = false)
    private Timestamp createTime;
    @Column(name = "last_login",nullable = false)
    private Timestamp lastLogin;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "categoria",nullable = false)
    private CategoryUser categoryUser;

    public User() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public CategoryUser getCategoryUser() {
        return categoryUser;
    }

    public void setCategoryUser(CategoryUser categoryUser) {
        this.categoryUser = categoryUser;
    }
    
    
    
}
