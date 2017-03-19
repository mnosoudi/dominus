package com.dominus.dominus;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

public class SignUpView extends SignUpViewDesign implements View {

    public static final String VIEW_NAME = "signup";
    
    public SignUpView()
    {
    	upload.setVisible(false);
    	query.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if(query.getValue().equals("Landlord"))
					upload.setVisible(true);
				else
					upload.setVisible(false);
					
			}
		});
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub
    }
}
