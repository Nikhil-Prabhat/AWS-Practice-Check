package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
