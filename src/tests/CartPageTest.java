package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartPage;
import pages.StoreItemPage;
import utils.ExcelUtils;

public class CartPageTest {
	
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
	public void addItemsTest() {
		CartPage cp = new CartPage(driver, locators, waiter);
		StoreItemPage sip = new StoreItemPage(driver, locators, waiter);
		SoftAssert sa = new SoftAssert();
		
		ExcelUtils eu = new ExcelUtils();
		eu.setExcell("data/pet-store-data.xlsx");
		eu.setWorkSheet(0);
		
		for (int i = 1; i < eu.getRowNumber(); i++) {
			this.driver.navigate().to(ExcelUtils.getDataAt(i, 1));
			sip.clickAddToCart();
			String ID  = ExcelUtils.getDataAt(i, 0);
			sa.assertTrue(cp.checkIsItemInCart(ID));	
		}
		
	}
		
	@Test
	public void deleteCookies() {
		this.driver.navigate().to(this.locators.getProperty("cart_url"));
		this.driver.manage().deleteAllCookies();
		this.driver.navigate().refresh();
		Assert.assertTrue(this.driver.findElement(By.xpath(this.locators.getProperty("empty_cart_message"))).getText().contentEquals("Your cart is empty."));	
	}
	
	@AfterClass
	public void afterClass() {
		this.driver.close();
	}

}
