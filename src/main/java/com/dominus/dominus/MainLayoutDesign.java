package com.dominus.dominus;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class MainLayoutDesign extends HorizontalLayout {
	protected CssLayout menu;
	protected Button search;
	protected Button signup;
	protected TextField username;
	protected TextField password;
	protected Button login;
	protected Panel scroll_panel;

	public MainLayoutDesign() {
		Design.read(this);
	}
}
