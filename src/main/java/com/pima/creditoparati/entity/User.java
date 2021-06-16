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
	private Integer idUser;
	
	@Column(name = "username", length = 16)
	private String username;
	
	@Column(name = "email", length = 255)
	private String email;
	
	@Column(name = "password", length = 32)
	private String password;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private CategoryUser categoryUser;
	
	@Column(name = "status_flag")
	private Integer status_flag;
	
	@Column(name = "lastLogin")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date  dtLastLogin;
	
	@Column(name = "crtd_on")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date  crtd_on;
	
	@Column(name = "crtd_by", length = 50)
	private String  crtd_by;
	
	@Column(name = "mdfd_on")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date  mdfd_on;
	
	@Column(name = "mdfd_by", length = 50)
	private String  mdfd_by;
	
	@PrePersist
	public void prePersist() {
		crtd_on = new java.util.Date();
		mdfd_on = new java.util.Date();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public CategoryUser getCategoryUser() {
		return categoryUser;
	}

	public void setCategoryUser(CategoryUser categoryUser) {
		this.categoryUser = categoryUser;
	}

	public Integer getStatus_flag() {
		return status_flag;
	}

	public void setStatus_flag(Integer status_flag) {
		this.status_flag = status_flag;
	}

	public java.util.Date getDtLastLogin() {
		return dtLastLogin;
	}

	public void setDtLastLogin(java.util.Date dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}

	public java.util.Date getCrtd_on() {
		return crtd_on;
	}

	public void setCrtd_on(java.util.Date crtd_on) {
		this.crtd_on = crtd_on;
	}

	public String getCrtd_by() {
		return crtd_by;
	}

	public void setCrtd_by(String crtd_by) {
		this.crtd_by = crtd_by;
	}

	public java.util.Date getMdfd_on() {
		return mdfd_on;
	}

	public void setMdfd_on(java.util.Date mdfd_on) {
		this.mdfd_on = mdfd_on;
	}

	public String getMdfd_by() {
		return mdfd_by;
	}

	public void setMdfd_by(String mdfd_by) {
		this.mdfd_by = mdfd_by;
	}
	
}
