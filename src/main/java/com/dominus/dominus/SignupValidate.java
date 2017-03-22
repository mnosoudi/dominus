package com.dominus.dominus;

import java.util.Scanner;

public class SignupValidate 
{
	
	//This function will call all of the methods to validate the first name and last name
	public boolean validateName(String name)
	{
		if(!testLength(name))
		{
			return false;
		}
		
		if(!testLetters(name))
		{
			return false;
		}
		
		return true;
	}
	
	//This function will call all of the methods to validate the email
	public boolean validateEmail(String email)
	{
		if(!testAt(email))
		{
			return false;
		}
		
		if(!testPeriod(email))
		{
			return false;
		}
		
		return true;
	}
	
	//This function will call all of the methods to validate the email
	public boolean validatePassword(String password)
	{
			
		if(passwordNull(password))
		{
			//Delete later
			System.out.println("Password null error");
			return false;
		}
		
		
		if(passwordEmpty(password))
		{
			System.out.println("Password empty error");
			return false;
		}
		
		if(!passwordSize(password))
		{
			
			System.out.println("Password size error: " + password.length());
			return false;
		}
		
		return true;
	}

	//This function will call all of the methods to validate the password 
	
	public boolean testLength(String name)
	{
		//boolean result = false;
		
		if(name == null)
		{
			return false;
		}
		
		if(name == "")
		{
			return false;
		}
		
		if(name.length()>20)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	
	}
	
	public boolean testLetters(String name)
	{
		return name.matches("[a-zA-Z]+");
	}
	
	public boolean testAt(String email)
	{
		return email.matches("[^@]*@[^@]*");
	}
	
	public boolean testPeriod(String email)
	{
		return email.matches(".*[.].*");
	}
	
	public boolean passwordNull(String password)
	{
		return password.equals(null);
	}
	
	public boolean passwordEmpty(String password)
	{
		return password.equals("");
	}
	
	public boolean passwordSize(String password)
	{
		return (password.length() >= 6 && password.length() <= 20);
	}

	public boolean validateRegistrationNull(String string) {
		return string.equals(null);
	}

	public boolean validateRegistrationEmpty(String string) {
		// TODO Auto-generated method stub
		string = "";
		return string.isEmpty();
	}
	
}
