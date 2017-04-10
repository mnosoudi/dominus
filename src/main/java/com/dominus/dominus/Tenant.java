package com.dominus.dominus;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tenant {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private int ID_Tenant;
	private String FirstName;
	private String LastName;
	private int Rating;
	private int NumOfRating;
	private String Password;
	private String Email;
	private int ID_Landlord;
	protected EntityManager em;		
		

	public Tenant(){
		
	}
	
	
	public Tenant(EntityManager em) {
  			    this.em = em;
  			  }	
	
	public int getID_Tenant() {
		return ID_Tenant;

		
	}
	public void setID_Tenant(int iD_Tenant) {
		ID_Tenant = iD_Tenant;
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
	public int getID_Landlord() {
		return ID_Landlord;
	}
	public void setID_Landlord(int iD_Landlord) {
		ID_Landlord = iD_Landlord;
	}
	
	
	
	
	
	
	
}