package com.dominus.dominus;

public class Database {
public static void signUp(String firstName, String lastName, String username, String password){
	//Send infortmation to database
}

//Currently used to test logging in, in the future it will get the hashed password from the
//database
public static String getPassword(String email){
	if(email.equals("test@email.com"))
			return Authorizer.hashIt("test12345");
	else
		return "";
}

//get the number of ratings from the database
public static int getRatingTotal(String email){return 5;}

//get the sum of ratings from the database
public static int getRatingSum(String email){return 23;}
}
