package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.MenuItem;

@FeignClient(name = "menu-service", url = "localhost:8080")
public interface OrderClient {

	@GetMapping("menu/viewall")
	public List<MenuItem> getAll();

	@GetMapping("menu/{id}")
	public MenuItem getById(@RequestHeader(name="auth")String token,@PathVariable("id") int id); 

}
