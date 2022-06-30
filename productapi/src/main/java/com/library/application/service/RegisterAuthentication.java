package com.library.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.application.dao.Registerrepo;
import com.library.application.entities.UserRegistration;

@Component
public class RegisterAuthentication {
	
	@Autowired
	Registerrepo registerrepo;
	
	public Boolean authenicate(UserRegistration userRegistration)
	{
		
		if(registerrepo.getRegUser(userRegistration.getEmail())==null)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
