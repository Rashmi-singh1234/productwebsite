package com.library.application.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.application.dao.Loginrepo;
import com.library.application.entities.UserLogin;
@Service
public class CustomUserdetailService implements UserDetailsService {
@Autowired
Loginrepo loginrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user=loginrepo.findByIdEmail(username);
		
	    if (user == null) {
	        throw new UsernameNotFoundException("Not found!");
	    }

	    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
		
	}

}
