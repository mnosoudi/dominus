package com.dominus.dominus;

import java.io.File;

import com.vaadin.data.Item;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.v7.ui.VerticalLayout;

public class TenantView extends TenantDesign implements View{
	public static final String VIEW_NAME = "Tenant";
	
	public TenantView(){
		Table tenants = new Table();
		tenants.addContainerProperty("Tenants", String.class, null);
		Object tenant = tenants.addItem();
		Item tenantitem = tenants.getItem(tenant);
		tenantitem.getItemProperty("Tenants").setValue("John Doe");
		tenants.setWidth("200");
		
		//Lists all the tenants on the database and their rating
		HorizontalLayout vertical = new HorizontalLayout();
		hlayout.addComponent(vertical);
		vertical.addComponent(tenants);
		vertical.setComponentAlignment(tenants, Alignment.MIDDLE_CENTER);
		//vertical.setMargin(true);
		
		
		Label tenantName = new Label();
		Label tenantRating = new Label();
		
		//submit rating button
		Button btnSubmitRating = new Button("Submit Rating");
		btnSubmitRating.addStyleName("friendly");
		
		//Displaying landlord's rating from the database
		vertical.addComponents(tenantName, tenantRating);
		
		HorizontalLayout ratingLayout = new HorizontalLayout();
		ratingLayout.addComponent(tenantName);
		ratingLayout.addComponent(tenantRating);
		ratingLayout.setSpacing(true);
		
		//new rating to add to the current landlord
		VerticalLayout newRatingLayout = new VerticalLayout();
		HorizontalLayout newSubmitRating = new HorizontalLayout();		
		newSubmitRating.addComponent(btnSubmitRating);
		
		OptionGroup rating = new OptionGroup("Rating");
		rating.addItems(1,2,3,4,5);
		rating.addStyleName("horizontal");
		newRatingLayout.addComponent(rating);
		newRatingLayout.setSpacing(true);
		FormLayout ratingForm = new FormLayout(ratingLayout, newRatingLayout, newSubmitRating);
		ratingForm.setMargin(true);
		
		Panel ratingPanel = new Panel("Rating", ratingForm);
		ratingPanel.setWidth("450");
		ratingPanel.setHeight("300");
		
		vertical.addComponent(ratingPanel);
		vertical.setSpacing(true);
		ratingPanel.setVisible(false);
		tenants.setSelectable(true);
		tenants.addItem();
		
		
		tenants.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			  @Override
			  public void itemClick(ItemClickEvent event) {
				String email = "place@hol.der"; //email is not currently in table
			  	Object rowId = tenants.getValue(); // get the selected rows id
		      	String name = (String)tenants.getContainerProperty(tenant,"Landlords").getValue(); 
			  	ratingPanel.setVisible(true);
		      	tenantName.setValue(name);
			  	int ratingeq = Database.getRatingTotal(email)/Database.getRatingSum(email);
			  	tenantRating.setValue(Integer.toString(ratingeq));
			  }
			});	
		
		System.out.println("Value"+tenants.getValue());
		
		addComponent(hlayout);
		setComponentAlignment(hlayout,Alignment.TOP_LEFT);
		setHeight("100%");
		setMargin(true);
		
	}
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
