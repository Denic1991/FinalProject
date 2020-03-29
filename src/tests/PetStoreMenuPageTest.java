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
import org.testng.asserts.SoftAssert;

import pages.PetStoreMenuPage;

public class PetStoreMenuPageTest {

	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.locators =  new Properties();
		locators.load(new FileInputStream("config/petstore.properties"));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	@Test
	public void linksVerification() {
		driver.navigate().to(this.locators.getProperty("petstore_menu_url"));
		PetStoreMenuPage mp = new PetStoreMenuPage(driver, locators, waiter);
		
		Assert.assertTrue(mp.checkCenterNaviLinks());
		Assert.assertTrue(mp.checkLeftNaviLinks());
		Assert.assertTrue(mp.checkImageNaviLinks());
				
	}
	@Test
	public void singInButtonTest() {
		driver.navigate().to(this.locators.getProperty("petstore_menu_url"));
		PetStoreMenuPage mp = new PetStoreMenuPage(driver, locators, waiter);
		mp.clickSingIn();
		
		Assert.assertTrue(mp.isSingInPageValid());
	}
	
	@AfterClass
	public void afterClass() {
		this.driver.close();
	}
}
