package com.dominus.dominus;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vaadin.testbench.*;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.TextFieldElement;

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
	}
	
	@Test
	public void testSearchButton() {
		// Find an element to interact upon
		ButtonElement logInButton = $(ButtonElement.class).caption("Search").first();
	    logInButton.click();
	}
	
	@Test
	public void testUsername() {
		TextFieldElement textField1 = $(TextFieldElement.class).first();
		textField1.click();
	}
	
	@Test
	public void testPassword() {
		TextFieldElement textField2 = $(TextFieldElement.class).get(1);
		textField2.click();
	}
	
	@Test
	public void testLogIn() {
		ButtonElement logInButton = $(ButtonElement.class).caption("Log In").first();
		logInButton.click();
	}

	@After
	public void teatDown() throws Exception {
		driver.quit();
	}
}
	
