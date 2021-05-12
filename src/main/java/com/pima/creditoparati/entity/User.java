package com.pima.creditoparati.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	
	private String userName;
	private String email;
	private String password;
	private Integer activo;
	
	@OneToOne
	@JoinColumn(name = "idCategoryUser")
	//@RestResource (path = "libraryAddress", rel="address")
	private CategoryUser categoryUser;
	
	@Column(name = "dtLastLogin", length = 50)
	@Temporal(TemporalType.DATE)
	private java.util.Date  dtLastLogin;
	
	@Column(name = "dtCreate", length = 50)
	@Temporal(TemporalType.DATE)
	private java.util.Date  dtCreate;
	
	@Column(name = "dtModify", length = 50)
	@Temporal(TemporalType.DATE)
	private java.util.Date  dtModify;
	
	@PrePersist
	public void prePersist() {
		dtModify = new java.util.Date();
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public CategoryUser getCategoryUser() {
		return categoryUser;
	}

	public void setCategoryUser(CategoryUser categoryUser) {
		this.categoryUser = categoryUser;
	}

	public java.util.Date getDtLastLogin() {
		return dtLastLogin;
	}

	public void setDtLastLogin(java.util.Date dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}

	public java.util.Date getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(java.util.Date dtCreate) {
		this.dtCreate = dtCreate;
	}

	public java.util.Date getDtModify() {
		return dtModify;
	}

	public void setDtModify(java.util.Date dtModify) {
		this.dtModify = dtModify;
	}
	
}
