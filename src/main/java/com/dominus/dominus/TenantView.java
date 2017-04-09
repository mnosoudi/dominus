package com.dominus.dominus;

import java.io.File;

import org.h2.engine.Database;

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
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.v7.ui.VerticalLayout;

public class TenantView extends TenantDesign implements View{
	public static final String VIEW_NAME = "Tenant";
	
	public TenantView(){
		Table Tenants = new Table();
		Tenants.addContainerProperty("Tenants", String.class, null);
		
		Object Tenant = Tenants.addItem();
		Item Tenantitem = Tenants.getItem(Tenant);
		Tenantitem.getItemProperty("Tenants").setValue("John Doe");
		hlayout.addComponent(Tenants);
		hlayout.setComponentAlignment(Tenants, Alignment.MIDDLE_LEFT);
		VerticalLayout vlayout = new VerticalLayout();
		hlayout.addComponent(vlayout);
		hlayout.setComponentAlignment(vlayout, Alignment.MIDDLE_RIGHT);
		Label TenantName = new Label();
		Label TenantRating = new Label();
		vlayout.addComponents(TenantName, TenantRating);
		vlayout.setComponentAlignment(TenantName, Alignment.TOP_CENTER);
		vlayout.setComponentAlignment(TenantRating, Alignment.BOTTOM_CENTER);
		OptionGroup rating = new OptionGroup("Rating");
		
		Button submitRate = new Button("Submit Rating");
		
		
		rating.addItems(1,2,3,4,5);
		vlayout.addComponents(rating,submitRate);
		//vlayout.addComponent(submitRate);
		rating.setVisible(false);
		Tenants.setSelectable(true);
		submitRate.setVisible(false);
		
		
		Tenants.addItem();
		
		Tenants.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			  @Override
			  public void itemClick(ItemClickEvent event) {
				  rating.setVisible(true);
				  TenantName.setValue("John Doe");
				  TenantRating.setValue("Rating: 5");
				  submitRate.setVisible(true);
				  
				  submitRate.addClickListener(new Button.ClickListener() {
					
					@Override
					public void buttonClick(ClickEvent event) {
						// TODO Auto-generated method stub
						//Database stuff
					}
				});
				
				  
			  //int TenantID = Tenants.getValue().getID();
			  //TenantName.setCaption(database.get(id = TenantID));
			  //andlordRating.setCaption(database.getTotalRating / database.getNumberofRatings));
			    
			  }
			});	
		
		System.out.println("Value"+Tenants.getValue());
		
	}
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
