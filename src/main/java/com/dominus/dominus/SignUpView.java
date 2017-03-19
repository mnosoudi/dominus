package com.dominus.dominus;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class SignUpView extends SignUpViewDesign implements View {

    public static final String VIEW_NAME = "signup";
    
    @Override
    public void enter(ViewChangeEvent event) 
    { 
        submit.addClickListener(new Button.ClickListener() 
        {
            public void buttonClick(ClickEvent event) 
            {
            	SignupValidate validate = new SignupValidate();
            	
            	//Not sure if this is necessary or not 
            	boolean success = true;
            	
            	//Validating the first name
            	if(!validate.validateName(firstName.getValue()) && success==true)
            	{
            		signupError("Make sure you entered a valid first name");
            		success = false;
            	}
            	
            	//Validating the last name
            	if(!validate.validateName(lastName.getValue()) && success==true)
            	{
            		signupError("Make sure you entered a valid last name");
            		success = false;
            	}
            	
            	//Validating the email 
            	if(!validate.validateEmail(email.getValue()) && success==true)
            	{
            		signupError("Make sure you entered a valid email");
            		success = false;
            	}
            	
            	//Validating the password
            	if(!validate.validatePassword(password.getValue()) && success==true)
            	{
            		signupError("Make sure you entered a valid password");
            		success = false;
            	}
            	
            	//Both passwords match 
            	if(!(password.getValue().equals(confirmpass.getValue())) && success== true)
            	{
            		signupError("Make sure both passwords match");
            		success = false;
            	}
            	
            	//Terms and Conditions
            	if(!checkAgree.getValue() && success==true)
            	{
            		signupError("Make sure to agree to the Terms and Conditions");
            		success = false;
            	}
            		
                //Displays success notification if all of the fields are valid
            	if(success == true)
            	{
            		signupSuccess();
            	}
            	
            	
            	
            }
            
        });
    }
    
   
    
    //Failure Notification
	 public void signupError(String message)
	 {
		 Notification notif = new Notification(
				    "Signup Error",
				    message,
				    Notification.Type.ERROR_MESSAGE);
		 notif.setDelayMsec(2000);
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
    
    //Success Notification
	 public void signupSuccess()
	 {
		 Notification notif = new Notification(
				    "Signup Success",
				    "Signup was successful",
				    Notification.Type.HUMANIZED_MESSAGE);
		 notif.setDelayMsec(2000);
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
    
}
