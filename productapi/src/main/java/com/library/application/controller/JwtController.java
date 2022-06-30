package com.library.application.controller;

import java.io.Console;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.application.dao.Loginrepo;
import com.library.application.dao.Registerrepo;
import com.library.application.entities.UserLogin;
import com.library.application.entities.UserRegistration;
import com.library.application.model.JwtRequest;
import com.library.application.model.JwtResponse;
import com.library.application.service.CustomUserdetailService;
import com.library.application.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private Registerrepo registerrepo;
	@Autowired
	private CustomUserdetailService customUserdetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired 
	private Loginrepo loginrepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		
 		try {
 			
 			
 		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()) );
		
 		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
 	UserDetails userDetails	= this.customUserdetailService.loadUserByUsername(jwtRequest.getEmail());
 	Optional<UserRegistration> userRegistration=registerrepo.findById(jwtRequest.getEmail());
 	Optional<UserLogin> userLogin=loginrepo.findById(jwtRequest.getEmail());
 	 String token =this.jwtUtil.generateToken(userDetails);
 	 System.out.println("JwT"+token);
 	 
 	return ResponseEntity.ok(new JwtResponse(token,userRegistration.get().getFirstName()+" "+userRegistration.get().getLastName(),userLogin.get().getType()));
 		
	}

}
