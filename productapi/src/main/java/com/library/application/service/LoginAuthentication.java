package com.library.application.service;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.application.dao.Loginrepo;
import com.library.application.entities.UserLogin;

@Component
public class LoginAuthentication {
	
	@Autowired
	Loginrepo loginrepo;
	
	public Boolean authenticate(UserLogin userLogin)
	{
		
		System.out.println("password="+loginrepo.getUserByPasswordLogin(userLogin.getPassword(),userLogin.getEmail()));

		
		if(loginrepo.getUserByPasswordLogin(userLogin.getPassword(),userLogin.getEmail())!=null)
		{
			return true;
		}
		return false;
	}
}
