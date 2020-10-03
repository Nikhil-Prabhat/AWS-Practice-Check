package com.menuitem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menuitem.entity.Menuitem;

@Repository
public interface MenuItemRepository extends JpaRepository<Menuitem, Integer> {
}
