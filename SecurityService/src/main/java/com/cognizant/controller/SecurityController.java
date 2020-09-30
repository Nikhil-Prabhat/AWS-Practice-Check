package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.AuthResponse;
import com.cognizant.model.UserLoginCredentials;
import com.cognizant.model.UserToken;
import com.cognizant.repository.UserRepository;
import com.cognizant.service.CustomerDetailsService;
import com.cognizant.service.JwtUtil;

@RestController
@RequestMapping("auth")
public class SecurityController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerDetailsService custDetailsService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginCredentials userLoginCredentials) {
		final UserDetails userDetails = custDetailsService.loadUserByUsername(userLoginCredentials.getUid());
		return new ResponseEntity<>(new UserToken(userLoginCredentials.getUid(), jwtUtil.generateToken(userDetails)),
				HttpStatus.OK);
	}

	@GetMapping("/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("auth") String token) {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();

		if (jwtUtil.validateToken(token)) {
			res.setUid(jwtUtil.extractUsername(token));
			res.setValid(true);
			res.setName(userRepository.findById(jwtUtil.extractUsername(token)).orElse(null).getUsername());
		} else {
			res.setValid(false);

		}

		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
