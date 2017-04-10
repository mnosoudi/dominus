package com.dominus.dominus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String 	firstName;
	private String password;
	private String email;
	private String lastName;
	private Boolean islandlord;
	private String registrationNumber;
	
	
}
