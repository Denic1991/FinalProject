package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest {
	
	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.locators =  new Properties();
		this.locators.load(new FileInputStream("config/petstore.properties"));
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	@Test 
	public void EnterPageTest() {
		this.driver.navigate().to(this.locators.getProperty("petstore_url"));
		
		HomePage hp = new HomePage(driver, locators, waiter);
		hp.clickEnterButton();
		
		Assert.assertTrue(hp.isEneterPageValid());
	}
	
	@AfterClass
	public void afterClass() {
		this.driver.close();
	}

}
