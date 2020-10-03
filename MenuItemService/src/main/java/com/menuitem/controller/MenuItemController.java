package com.menuitem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.menuitem.client.AuthClient;
import com.menuitem.client.AuthResponse;
import com.menuitem.entity.Menuitem;
import com.menuitem.exception.MenuItemNotFoundException;
import com.menuitem.service.MenuItemService;

@RestController
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	@Autowired
	AuthClient authclient;

	@RequestMapping(path = "/menu/viewall", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMenuItem(@RequestHeader(name = "Authorization") String token) {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<List<Menuitem>>(menuItemService.getallMenuItem(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(path = "/menu/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMenuItemById(@RequestHeader(name = "Authorization") String token,
			@PathVariable int id) {
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			Menuitem menuItemById;
			try {
				menuItemById = menuItemService.getMenuItemById(id);
			} catch (MenuItemNotFoundException e) {
				return new ResponseEntity<>("Item not Found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Menuitem>(menuItemById, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}
	}
}
