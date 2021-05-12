package com.Xoot.CreditoParaTi.models.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.Xoot.CreditoParaTi.entity.User;

public interface IUserDao extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM creditoparati.user WHERE activo = 1 AND user_name=:userName AND password=:pass LIMIT 1;")
    User findByLogin(@Param("userName") String userName, @Param("pass") String pass);
}
