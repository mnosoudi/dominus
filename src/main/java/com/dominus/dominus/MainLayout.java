package com.dominus.dominus;


import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;

public class MainLayout extends MainLayoutDesign implements ViewDisplay {

    private static final String STYLE_SELECTED = "selected";
    private Navigator navigator;

    public MainLayout() {
        navigator = new Navigator(UI.getCurrent(), (ViewDisplay) this);
        addNavigatorView(SearchView.VIEW_NAME, SearchView.class, search);
        addNavigatorView(SignUpView.VIEW_NAME, SignUpView.class, signup);
        addNavigatorView(LoginView.VIEW_NAME, LoginView.class, login);
        if (navigator.getState().isEmpty()) {
            navigator.navigateTo(SearchView.VIEW_NAME);
        }
        
        
        
//        Authorizer authorizer = new Authorizer();
//      	final PasswordField tmpPassword = new PasswordField();
//      	password.addFocusListener(new FocusListener() {
//      		public void focus (FieldEvents.FocusEvent event) {
//      			menu.replaceComponent(password, tmpPassword);
//      			tmpPassword.focus();
//      		}
//      	});
//      	
//      	tmpPassword.addBlurListener(new BlurListener () {
//      		public void blur (FieldEvents.BlurEvent event) {
//      			password.setValue(tmpPassword.getValue());
//      			if (password.getValue().isEmpty()) {
//      				menu.replaceComponent(tmpPassword, password);
//      			}
//      		}
//      	});
        
      	Button logout = new Button("Logout");
      	//login.addStyleName("friendly");
      	
//      	login.addClickListener(event -> {
//			try {
//				if(authorizer.authorize(username.getValue(), password.getValue())){
//					loginSuccess();
//					menu.removeComponent(signup);
//					menu.removeComponent(username);
//					menu.removeComponent(password);
//					menu.removeComponent(login);
//					menu.removeComponent(tmpPassword);
//					Label label = new Label("Signed in as " + (String) VaadinSession.getCurrent().getAttribute("user"));
//					menu.addComponent(label);
//					menu.addComponent(logout);
//				}
//				else
//					loginError();
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//    	});
    }

    private void doNavigate(String viewName) {
        getUI().getNavigator().navigateTo(viewName);
    }

    private void addNavigatorView(String viewName,
            Class<? extends View> viewClass, Button menuButton) {
        navigator.addView(viewName, viewClass);
        menuButton.addClickListener(event -> doNavigate(viewName));
        menuButton.setData(viewClass.getName());
    }

    private void adjustStyleByData(Component component, Object data) {
        if (component instanceof Button) {
            if (data != null && data.equals(((Button) component).getData())) {
                component.addStyleName(STYLE_SELECTED);
            } else {
                component.removeStyleName(STYLE_SELECTED);
            }
        }
    }

    @Override
    public void showView(View view) {
        if (view instanceof Component) {
            scroll_panel.setContent((Component) view);
            Iterator<Component> it = menu.iterator();
            while (it.hasNext()) {
                adjustStyleByData(it.next(), view.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("View is not a Component");
        }
    }
    
    //displays error message when invalid input is entered
    public void loginError()
    {
		 Notification notif = new Notification(
				    "Login Error",
				    "Wrong username or password",
				    Notification.Type.ERROR_MESSAGE);
		 notif.setDelayMsec(2000);
		 //position message in the top left corner
		 notif.setPosition(Position.TOP_LEFT);
		 notif.show(Page.getCurrent());
	 }
    
	public void loginSuccess()
	{
		Notification notif = new Notification(
				"Login", 
				"Login was Successful",
				Notification.Type.HUMANIZED_MESSAGE);
		notif.setDelayMsec(2000);
		notif.setPosition(Position.TOP_LEFT);
		notif.show(Page.getCurrent());
	}

}