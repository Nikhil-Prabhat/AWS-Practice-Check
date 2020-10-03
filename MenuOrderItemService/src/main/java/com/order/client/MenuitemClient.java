package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.dojo.Menuitem;


@FeignClient(url="http://localhost:8081",name="Menu-item-service")
public interface MenuitemClient {
	
	@RequestMapping(path = "/menu/{id}", method = RequestMethod.GET)
	public Menuitem getMenuItemById(@RequestHeader(name = "Authorization") String token, @PathVariable int id);
	

}
