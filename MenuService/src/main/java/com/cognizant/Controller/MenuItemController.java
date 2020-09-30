package com.cognizant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.MenuItem;
import com.cognizant.service.MenuItemServiceImpl;

@RestController
@RequestMapping("menu")
public class MenuItemController {

	@Autowired
	private MenuItemServiceImpl menuItemServiceImpl;

	@GetMapping("viewall")
	public ResponseEntity<?> getAll() {
		List<MenuItem> menuItemList = menuItemServiceImpl.getAll();

		return new ResponseEntity<>(menuItemList, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		MenuItem menuItem = menuItemServiceImpl.getById(id);
		if (menuItem == null) {
			return new ResponseEntity<>("MenuItem Not Found", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(menuItem, HttpStatus.OK);
		}
	}

}
