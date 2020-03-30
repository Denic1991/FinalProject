package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	
	public SignInPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("username")));
	}
	
	public void setUsername(String username) {
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("password")));	
	}
	
	public void setPassword(String password) {
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
	}
	
	public WebElement getLogInButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("login_button")));
	}
	
	public void clickLogInButton() {
		this.getLogInButton().click();
	}
	
	public WebElement getRegister() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("register")));
	}
	
	public void clickRegisterNow() {
		this.getRegister().click();
	}
	
	public void signIn(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogInButton();
	}
	
	public WebElement getSingOut() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("sing_out")));
	}
	
	public boolean isSingInSuccessful() {
		boolean displayed = false;
		if (this.getSingOut().isDisplayed()) {
			displayed = true;
		}
		return displayed;
	}

}
