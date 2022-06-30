package com.library.application.dao;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.library.application.entities.UserLogin;

@Component
public interface Loginrepo extends CrudRepository<UserLogin,String> {

	@Query("from UserLogin as u where u.password=:pass and u.email=:mail")
	
	public UserLogin getUserByPasswordLogin(@Param("pass") String password,@Param("mail") String email);

	@Query("from UserLogin as u where u.email=:mail")
	public UserLogin findByIdEmail(@Param("mail") String username);
	
}
