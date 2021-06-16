package com.pima.creditoparati.dao;

import com.pima.creditoparati.entity.User;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserDao extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM creditoparati.user WHERE status_flag = 1 AND username=:userName AND password=:pass LIMIT 1;")
    User findByLogin(@Param("userName") String userName, @Param("pass") String pass);
	
	@Query(nativeQuery = true, value = "SELECT * FROM creditoparati.user WHERE status_flag = 1;")
    List<User> findAllActive();
}
