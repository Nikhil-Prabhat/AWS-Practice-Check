package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.LoginUser;

public interface UserRepository extends JpaRepository<LoginUser, String> {

}
