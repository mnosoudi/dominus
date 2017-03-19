package com.dominus.dominus;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vaadin.testbench.*;

public class TestBenchUI extends TestBenchTestCase {

	@Rule
	public ScreenshotOnFailureRule screenshotOnFailureRule = new ScreenshotOnFailureRule(this,true);
	
	@Before
	public void setUp() throws Exception {
		setDriver(new FirefoxDriver());
	}
	
	private void openTestUrl() {
		getDriver().get("http://localhost:8080/dominus");
	}
	
	
}
