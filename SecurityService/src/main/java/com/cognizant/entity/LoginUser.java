package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LoginUser {
	@Id
	private String userid;
	private String username;
	private String userpassword;

}
