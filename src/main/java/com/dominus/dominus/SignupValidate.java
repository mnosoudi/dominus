package com.dominus.dominus;

import java.util.Scanner;

public class SignupValidate 
{
	
	//This function will call all of the methods to validate
	public boolean validate(String name)
	{
		return false;
	}
	
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
	
}
