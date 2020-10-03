package com.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.Orderitem;

@Repository
public interface OrderItemRepository extends JpaRepository<Orderitem, Integer> {
}
