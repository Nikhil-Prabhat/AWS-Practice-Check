package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.MenuItem;

public interface MenuItemServiceDao {

	public List<MenuItem> getAll();

	public MenuItem getById(int id);

}
