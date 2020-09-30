package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserToken {
	
	private String uid;
	private String authToken;

}
