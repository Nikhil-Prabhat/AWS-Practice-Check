package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
