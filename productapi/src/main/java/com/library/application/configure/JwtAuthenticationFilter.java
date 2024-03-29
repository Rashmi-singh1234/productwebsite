package com.library.application.configure;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.library.application.service.CustomUserdetailService;
import com.library.application.util.JwtUtil;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

	@Autowired
	private CustomUserdetailService customUserdetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			
		String requestTokenHeader=request.getHeader("Authorization");
		String email=null;
		String jwtToken=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				
				email=this.jwtUtil.getUsernameFromToken(jwtToken);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		UserDetails userDetails=this.customUserdetailService.loadUserByUsername(email);
			
			if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken	=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
			else {
				
				System.out.println("token is not validated");
			}
			
			
			
			
			
			
			
		}
		
		filterChain.doFilter(request, response);
		
		
		
		
	}

}
