/**
 * 
 */
package com.dominus.dominus;

import java.security.NoSuchAlgorithmException;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

/**
 * @author Kelvin
 *
 */
public class LoginView extends LoginViewDesign implements View {

	/**
	 * 
	 */
	public static final String VIEW_NAME = "login";
	
	public LoginView(){
		
		btnLogin.addClickListener(new Button.ClickListener() {
			
			Authorizer authorize = new Authorizer();
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					if(authorize.authorize(userName.getValue(), password.getValue())){
						//login successful
						getUI().getNavigator().navigateTo("search");
						Label label = new Label("Signed in as " + (String) VaadinSession.getCurrent().getAttribute("user"));
						addComponent(label);
						addComponent(btnSignup);
						//reset UI Components
						userName.setValue("");
						password.setValue("");
					} else{
						Notification.show("Incorrect Login Details!!!", Notification.Type.ERROR_MESSAGE);
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnSignup.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				getUI().getNavigator().navigateTo("signup");
			}
		});
	}
	@Override
	public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
