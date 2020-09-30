package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(url="http://localhost:8083/auth",name="security-service")
public interface AuthClient {
	
	@GetMapping("/validate")
	public AuthResponse verifyToken(@RequestHeader(name="auth",required=true)String token);


}
