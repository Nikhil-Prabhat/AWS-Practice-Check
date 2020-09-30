package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.entity.LoginUser;
import com.cognizant.repository.UserRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		
		LoginUser custuser = userRepository.findById(uid).orElse(null);
	
		return new User(custuser.getUserid(),custuser.getUserpassword(),new ArrayList<>());
	}
	
	

}
