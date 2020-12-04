package com.programming.learning.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.programming.learning.springblog.dto.LoginRequest;
import com.programming.learning.springblog.dto.RegisterRequest;
import com.programming.learning.springblog.model.Users;
import com.programming.learning.springblog.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	public void signUp(RegisterRequest registerRequest) {
		Users user = new Users();
		user.setUserName(registerRequest.getUsername());
		user.setPassword(encodePassword(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		userRepository.save(user);
	}
	
	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public void login(LoginRequest loginRequest) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
				loginRequest.getPassword()));
		
	}
}
