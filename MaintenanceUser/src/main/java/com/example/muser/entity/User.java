package com.example.muser.entity;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String  userName;
	private Area    area;
	private String  email;
	
}
