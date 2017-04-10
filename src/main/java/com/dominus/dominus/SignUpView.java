package com.dominus.dominus;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class SignUpView extends SignUpViewDesign implements View {

    public static final String VIEW_NAME = "signup";
    

    public SignUpView()
    {
    	//gets the landlords registration number
    	registrationNumber.setVisible(false);
    	query.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(query.getValue().equals("Landlord"))
					registrationNumber.setVisible(true);
				else
					registrationNumber.setVisible(false);
					
			}
		});
    }

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
            	if(!validate.validateName(firstName.getValue()))
            	{
            		signupError("Make sure you entered a valid first name");
            		success = false;
            	}
            	
            	//Validating the last name
            	else if(!validate.validateName(lastName.getValue()))
            	{
            		signupError("Make sure you entered a valid last name");
            		success = false;
            	}
            	
            	//Validating the email 
            	else if(!validate.validateEmail(email.getValue()))
            	{
            		signupError("Make sure you entered a valid email");
            		success = false;
            	}
            	
            	//Validating the password
            	else if(!validate.validatePassword(password.getValue()))
            	{
            		signupError("Make sure you entered a valid password");
            		success = false;
            	}
            	
            	//Both passwords match 
            	else if(!(password.getValue().equals(confirmpass.getValue())))
            	{
            		signupError("Make sure both passwords match");
            		success = false;
            	}
            	
            	//Terms and Conditions
            	else if(!checkAgree.getValue())
            	{
            		signupError("Make sure to agree to the Terms and Conditions");
            		success = false;
            	}
            	
            	else if(query.getValue() == null){
            		signupError("Are you a Tenant or a Landlord?");
            		success = false;
            	}
            		
                //call success method if all of the fields are valid
            	else if(success == true)
            	{
            		Database.signUp(firstName.getValue(), lastName.getValue(), email.getValue(), password.getValue());
            		getUI().getNavigator().navigateTo("search");
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
    
    //Send data to database and show Success Notification
	 public void signupSuccess()
	 {
		 String message;
		 if (query.getValue().equals("Landlord")){
			 message = "Signup for landlord account was successful.\nAdmin has recieved your registration number, you will be reviewed for verification shortly";
		 }
		 else
			 message = "Signup for tenant account was successful";
		 Notification notif = new Notification(
				    "Signup Success",
				    message,
				    Notification.Type.HUMANIZED_MESSAGE);
		 notif.setDelayMsec(2000);
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
    
}
