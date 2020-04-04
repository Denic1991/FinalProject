package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.RegistrationPage;
import utils.ExcelUtils;

public class RegistrationPageTest {

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
	public void RegistrationTest() {
		this.driver.navigate().to(this.locators.getProperty("registration_url"));
		RegistrationPage rp = new RegistrationPage(driver, locators, waiter);
		SoftAssert sa = new SoftAssert();
		
		ExcelUtils eu = new ExcelUtils();
		eu.setExcell("data/pet-store-data.xlsx");
		eu.setWorkSheet(1);
		
		for (int i = 1; i < eu.getRowNumber(); i++) {
			String uniqueID = UUID.randomUUID().toString();
			String userID = uniqueID.substring(0, 7);
			ExcelUtils.setDataAt(i, 0, userID);
			String newPassword = ExcelUtils.getDataAt(i, 1);
			String repeatPassword = ExcelUtils.getDataAt(i, 1);
			String name = ExcelUtils.getDataAt(i, 2);
			String lastName = ExcelUtils.getDataAt(i, 3);
			String email = ExcelUtils.getDataAt(i, 4);
			String phone = ExcelUtils.getDataAt(i, 5);
			String address1 = ExcelUtils.getDataAt(i, 6);
			String address2 = ExcelUtils.getDataAt(i, 7);
			String city = ExcelUtils.getDataAt(i, 8);
			String state = ExcelUtils.getDataAt(i, 9);
			String zip = ExcelUtils.getDataAt(i, 10);
			String country = ExcelUtils.getDataAt(i, 11);
			String language = ExcelUtils.getDataAt(i, 12);
			String category = ExcelUtils.getDataAt(i, 13);
			
			rp.registrationForm(userID, newPassword, repeatPassword, name, lastName, email, phone, address1, address2, city, state, zip, country, language, category);
			rp.clicSaveAccount();
			sa.assertTrue(rp.isRegistrationSuccessful());
		
			this.driver.navigate().to(this.locators.getProperty("registration_url"));
			
		}
		
	}
	
	@AfterClass
	public void afterClass() {
		this.driver.close();
	}
}
