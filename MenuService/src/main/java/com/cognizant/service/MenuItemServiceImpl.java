package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.MenuItem;
import com.cognizant.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemServiceDao {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getAll() {

		return menuItemRepository.findAll();
	}

	@Override
	public MenuItem getById(int id) {

		MenuItem menuItem = menuItemRepository.findById(id).orElse(null);

		return menuItem;

	}

}
