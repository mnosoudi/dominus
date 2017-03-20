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
	}

	@After
	public void teatDown() throws Exception {
		driver.quit();
	}
}
	
