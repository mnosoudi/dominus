package com.dominus.dominus;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vaadin.testbench.*;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;

public class TestBenchUI extends TestBenchTestCase {

	@Rule
	public ScreenshotOnFailureRule screenshotOnFailureRule = new ScreenshotOnFailureRule(this,true);
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/adamwoodland/Downloads/chromedriver");
		setDriver(new ChromeDriver());
	}
	
	@Test
	public void openTestUrl() {
		getDriver().get("http://localhost:8080/dominus");
	

		    // Find an element to interact upon
		    ButtonElement button =
		        $(ButtonElement.class).id("login");

		    // Click the button
		    button.click();
		    
		    // Check that the label text is correct
		    LabelElement label = $(LabelElement.class).first();
		    assertEquals("Login was Successful", label.getText());
		}

	@After
	public void teatDown() throws Exception {
		driver.quit();
	}
}
	
