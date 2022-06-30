package com.library.application.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.library.application.entities.UserLogin;
import com.library.application.entities.UserRegistration;


@Component
public interface Registerrepo extends CrudRepository<UserRegistration, String>{

@Query("from UserRegistration as u where u.email=:mail")
	
	public UserRegistration getRegUser(@Param("mail") String email);
}
