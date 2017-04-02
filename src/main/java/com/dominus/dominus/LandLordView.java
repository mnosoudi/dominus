package com.dominus.dominus;

import java.io.File;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class LandLordView extends LandLordViewDesign implements View{
	public static final String VIEW_NAME = "landlord";
	
	public LandLordView(){
		
		landlordName.setValue("Jane Doe");
		// Find the application directory
		String basepath = VaadinService.getCurrent()
		                  .getBaseDirectory().getAbsolutePath();

		// Image as a file resource
		FileResource resource = new FileResource(new File(basepath +
		                        "/WEB-INF/images/businesswoman.jpg"));	
		landlordImg.setSource(resource);
		
		landlordRating.setValue("Rating: 4.3");
	}
    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
