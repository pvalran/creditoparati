package com.pima.creditoparati.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CategoryUser")
public class CategoryUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoryUser;
	
	private String name;
	private Integer activo;
	
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

	public Long getIdCategoryUser() {
		return idCategoryUser;
	}

	public void setIdCategoryUser(Long idCategoryUser) {
		this.idCategoryUser = idCategoryUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
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
