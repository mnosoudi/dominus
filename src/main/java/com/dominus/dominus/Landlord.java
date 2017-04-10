package com.dominus.dominus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Landlord {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private Long ID_Landlord;
	private String FirstName;
	private String LastName;
	private int Rating;
	private int NumOfRating;
	private String Password;
	private String Email;
	private int Registration;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getRegistration() {
		return Registration;
	}
	public void setRegistration(int registration) {
		Registration = registration;
	}
	public void setID_Landlord(Long iD_Landlord) {
		ID_Landlord = iD_Landlord;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public int getNumOfRating() {
		return NumOfRating;
	}
	public void setNumOfRating(int numOfRating) {
		NumOfRating = numOfRating;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMail() {
		return Email;
	}
	public void setMail(String mail) {
		this.Email = mail;
	}
	
	
	
	
	
	
	
}