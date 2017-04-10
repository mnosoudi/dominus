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
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.v7.ui.VerticalLayout;

public class LandLordView extends LandLordViewDesign implements View{
	public static final String VIEW_NAME = "landlord";
	
	public LandLordView(){
		Table landlords = new Table();
		landlords.addContainerProperty("Landlords", String.class, null);
		Object landlord = landlords.addItem();
		Item landlorditem = landlords.getItem(landlord);
		landlorditem.getItemProperty("Landlords").setValue("John Doe");
		landlords.setWidth("200");
		
		//Lists all the landlords on the database and their rating
		HorizontalLayout vertical = new HorizontalLayout();
		hlayout.addComponent(vertical);
		vertical.addComponent(landlords);
		vertical.setComponentAlignment(landlords, Alignment.MIDDLE_CENTER);
		//vertical.setMargin(true);
		
		
		Label landlordName = new Label();
		Label landlordRating = new Label();
		
		//submit rating button
		Button btnSubmitRating = new Button("Submit Ratting");
		btnSubmitRating.addStyleName("friendly");
		
		//Displaying landlord's rating from the database
		vertical.addComponents(landlordName, landlordRating);
		
		HorizontalLayout ratingLayout = new HorizontalLayout();
		ratingLayout.addComponent(landlordName);
		ratingLayout.addComponent(landlordRating);
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
		landlords.setSelectable(true);
		landlords.addItem();
		
		
		landlords.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			  @Override
			  public void itemClick(ItemClickEvent event) {
				  ratingPanel.setVisible(true);
				  landlordName.setValue("John Doe");
				  landlordRating.setValue("Rating: 5");
			  //int landlordID = landlords.getValue().getID();
			  //landlordName.setCaption(database.get(id = landlordID));
			  //andlordRating.setCaption(database.getTotalRating / database.getNumberofRatings));
			    
			  }
			});	
		
		System.out.println("Value"+landlords.getValue());
		
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
