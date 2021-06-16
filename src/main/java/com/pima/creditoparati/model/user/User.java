/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pima.creditoparati.model.user;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;

/**
 *
 * @author super
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int idUser;
    @Column(name = "username",length = 16,nullable = false)
    private String userName;
    @Column(length = 255,nullable = false)
    @Email
    private String email;
    @GeneratedValue
    @Column(name = "create_time",nullable = false)
    private Timestamp createTime;
    @Column(nullable = false)
    private Date lastLogin;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "category",nullable = false)
    private CategoryUser categoryUser;

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

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
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
