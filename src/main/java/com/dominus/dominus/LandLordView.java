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
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.v7.ui.VerticalLayout;

public class LandLordView extends LandLordViewDesign implements View{
	public static final String VIEW_NAME = "landlord";
	
	public LandLordView(){
		Table landlords = new Table();
		landlords.addContainerProperty("Landlords", String.class, null);
		Object landlord = landlords.addItem();
		Item landlorditem = landlords.getItem(landlord);
		landlorditem.getItemProperty("Landlords").setValue("John Doe");
		hlayout.addComponent(landlords);
		hlayout.setComponentAlignment(landlords, Alignment.MIDDLE_LEFT);
		VerticalLayout vlayout = new VerticalLayout();
		hlayout.addComponent(vlayout);
		hlayout.setComponentAlignment(vlayout, Alignment.MIDDLE_RIGHT);
		Label landlordName = new Label();
		Label landlordDesc = new Label(); 
		Label landlordRating = new Label();
		vlayout.addComponents(landlordName, landlordDesc, landlordRating);
		landlords.setSelectable(true);
		landlords.addItem();
		
		landlords.addItemClickListener(new ItemClickEvent.ItemClickListener() {
			  @Override
			  public void itemClick(ItemClickEvent event) {
			  //int landlordID = landlords.getValue().getID();
			  //landlordName.setCaption(database.get(id = landlordID));
			  //andlordRating.setCaption(database.getTotalRating / database.getNumberofRatings));
			    
			  }
			});	
		
		System.out.println("Value"+landlords.getValue());
		
	}
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
