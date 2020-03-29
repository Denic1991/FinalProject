package pages;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	public HomePage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}
	
	public WebElement getEnterPage() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("enter_page")));
	}
	
	public void clickEnterButton() {
		this.getEnterPage().click();
	}
	
	public WebElement getLogoImg() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("logo_img")));
	}
	
	public boolean isEneterPageValid() {
		boolean displayed = false;
		if (this.getLogoImg().isDisplayed()) {
			displayed = true;
		}
		return displayed;
	}
}