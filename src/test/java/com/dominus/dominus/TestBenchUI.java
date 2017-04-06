package com.dominus.dominus;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

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
	
	public void openTestUrl() {
		getDriver().get("http://localhost:8080");
	}
	
	@Test
	public void testSearch() {
		openTestUrl();
		ButtonElement SearchButton = $(ButtonElement.class).caption("Search").first();
	    SearchButton.click();
	    assertEquals(1, $(TextFieldElement.class).all().size());
	    assertEquals("Search Landlords", $(TextFieldElement.class).first().getCaption());
	}
	
	@Test
	public void testSignUp() {
		openTestUrl();
		ButtonElement SignUpButton = $(ButtonElement.class).caption("Sign Up").first();
		SignUpButton.click();
		assertEquals("Sign Up for Dominus", $(LabelElement.class).first().getText());
		assertEquals(5, $(TextFieldElement.class).all().size());
		assertEquals("First Name", $(TextFieldElement.class).all().get(0).getCaption());
		assertEquals("Password", $(TextFieldElement.class).all().get(1).getCaption());
		assertEquals("Email", $(TextFieldElement.class).all().get(2).getCaption());
		assertEquals("Last Name", $(TextFieldElement.class).all().get(3).getCaption());
		assertEquals("Confirm Password", $(TextFieldElement.class).all().get(4).getCaption());
	}
	
	@Test
	public void testLogInButton() {
		openTestUrl();
		List<ButtonElement> allButtons = $(ButtonElement.class).all();
		ButtonElement LogInButton = allButtons.get(2);
		LogInButton.click();
	}

	@After
	public void testDown() throws Exception {
		driver.quit();
	}
}
	
