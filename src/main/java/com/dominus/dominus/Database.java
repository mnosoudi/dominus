package com.dominus.dominus;


//This class simulates one row of the database, will later be changed for general database use

public class Database {
	
	private static int ratingtotal = 1;
	private static int ratingsum = 1;
	private static String firstNameD;
	private static String lastNameD;
	private static String emailD;
	private static String passwordD;
	
	public static void signUp(String firstName, String lastName, String email, String password){
		firstNameD = firstName;
		lastNameD = lastName;
		emailD = email;
		passwordD = password;
	}

	//Currently used to test logging in, in the future it will get the hashed password from the
	//database
	public static String getPassword(String email){
		if(email.equals(emailD))
				return Authorizer.hashIt(passwordD);
		else
			return "";
	}

	//get the number of ratings from the database
	public static int getRatingTotal(){return ratingtotal;}

	//get the sum of ratings from the database
	public static int getRatingSum(){return ratingsum;}
	
	public static String getEmail(){return emailD;}

	public static String getName(){
		return firstNameD+" "+lastNameD;
	}


	//add a rating to the database
	public static void addRating(int rating){
		ratingtotal++;
		ratingsum += rating;
	}

}
