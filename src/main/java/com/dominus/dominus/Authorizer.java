package com.dominus.dominus;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class Authorizer 
{
	 public Authorizer()
	 {
	 }
	  
	 
	 public boolean authorize(String username, String password) throws NoSuchAlgorithmException
	 {
		 Pattern pattern = Pattern.compile("\\b[a-zA-Z][a-zA-Z0-9\\-._@]{7,}\\b");
		 Matcher unamematcher = pattern.matcher(username);
		 Matcher pwdmatcher = pattern.matcher(password);
		 boolean success = false;
		 
			 if(unamematcher.matches() && pwdmatcher.matches()){
				 String hashedpass;
				 hashedpass = hashIt(password);
				 if(login(username, hashedpass)){
					 VaadinSession.getCurrent().setAttribute("user", username);
					 success = true;
				 }
			 }
			 else
				 success = false;
			 return success;
	 }
	 

	 

	 //password hasher method
	 public static String hashIt(String password)
	 {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            md.update(password.getBytes());
	            byte[] bytes = md.digest();
	            //convert string to hex
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            return sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	        	return null;
	        }
	   }
	
	

	 
	 
	 public boolean login(String email, String password)
	 {
		 //dummy database
		 String hashedpass = hashIt(password);
		 if((Database.getPassword(email).equals(hashedpass)) || (email.equals("test@email.com") && password.equals(hashIt("password123"))))
			 return true;
		 else
			 return false;
	 }
	 
	 public void logout(){
		 VaadinSession.getCurrent().setAttribute("user", null);
	 }
}

