package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.PetStoreMenuPage;
import pages.SignInPage;
import utils.ExcelUtils;

public class SingInPageTest {

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
	public void SingInTest() {
		driver.navigate().to(this.locators.getProperty("sing_in_url"));
		SignInPage sp = new SignInPage(driver, locators, waiter);
		SoftAssert sa = new SoftAssert();
		
		ExcelUtils eu = new ExcelUtils();
		eu.setExcell("data/pet-store-data.xlsx");
		eu.setWorkSheet(1);
		
		for (int i = 1; i < eu.getRowNumber(); i++) {
			
			String username = ExcelUtils.getDataAt(i, 0);
			String password = ExcelUtils.getDataAt(i, 1);
			
			sp.signIn(username, password);
			sa.assertTrue(sp.isSingInSuccessful());
			driver.navigate().to(this.locators.getProperty("sing_in_url"));
	
		}
	}
	
	@AfterClass
	public void afterClass() {
		this.driver.close();
	}
}
