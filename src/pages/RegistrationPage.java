package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	public RegistrationPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}
	
	public WebElement getUserID() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("user_id")));
	}
	
	public void setUserID(String userID) {
		this.getUserID().clear();
		this.getUserID().sendKeys(userID);
	}
	
	public WebElement getNewPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("new_password")));
	}
	
	public void setNewPassword(String newPassword) {
		this.getNewPassword().clear();
		this.getNewPassword().sendKeys(newPassword);
	}
	
	public WebElement getRepeatPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("repeat_password")));
	}
	
	public void setRepeatPassword(String repeatPassword) {
		this.getRepeatPassword().clear();
		this.getRepeatPassword().sendKeys(repeatPassword);
	}
		
	public WebElement getFirstName() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("first_name")));	
	}
	
	public void setFirstName(String name) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(name);
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("last_name")));
	}
	
	public void setLastName(String lastName) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
	}
	
	public WebElement getEmail() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("email")));
	}
	
	public void setEmail(String email) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
	}
	
	public WebElement getPhone() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("phone")));	
	}
	
	public void setPhone(String phone) {
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
	}
	
	public WebElement getAddress1() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("address_1")));	
	}
	
	public void setAddress1(String address1) {
		this.getAddress1().clear();
		this.getAddress1().sendKeys(address1);
	}
	
	public WebElement getAddress2() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("address_2")));	
	}
	
	public void setAddress2(String address2) {
		this.getAddress2().clear();
		this.getAddress2().sendKeys(address2);
	}
	
	public WebElement getCity() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("city")));
	}
	
	public void setCity(String city) {
		this.getCity().clear();
		this.getCity().sendKeys(city);
	}
	
	public WebElement getState() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("state")));	
	}
	
	public void setState(String state) {
		this.getState().clear();
		this.getState().sendKeys(state);
	}
	
	public WebElement getZip() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("zip")));	
	}
	
	public void setZip(String zip) {
		this.getZip().clear();
		this.getZip().sendKeys(zip);
	}
	
	public WebElement getCountry() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("country")));	
	}
	
	public void setCountry(String country) {
		this.getCountry().clear();
		this.getCountry().sendKeys(country);
	}
	
	public WebElement getLanguagePreference() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("language_preference")));
	}
	
	public void setLanguagePreference(String language) {
		Select lp = new Select(this.getLanguagePreference());
		lp.selectByValue(language);
	}
	
	public WebElement getFavouriteCategoty() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("favourite_category")));
	}
	
	public void setFavoriteCategory(String category) {
		Select fc = new Select(this.getFavouriteCategoty());
		fc.selectByValue(category);	
	}
	
	public WebElement getEnableMyList() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("my_list_checkbox")));
	}
	
	public void clickEnableMyList() {
		this.getEnableMyList().click();
	}
	
	public WebElement getEnableMyBanner() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("my_banner_checkbox")));
	}
	
	public void clickEnalbleMyBanner() {
		this.getEnableMyBanner().click();
	}
	
	public WebElement getSaveAccountButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("save_account")));
	}
	
	public void clicSaveAccount() {
		this.getSaveAccountButton().click();
	}
	
	public void registrationForm(String userID, String newPassword, String repeatPassword, String name, String lastName,
			                                    String email, String phone, String address1, String address2, String city, 
			                                    String state, String zip, String country, String language, String category ) {
		this.setUserID(userID);
		this.setNewPassword(newPassword);
		this.setRepeatPassword(repeatPassword);
		this.setFirstName(name);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPhone(phone);
		this.setAddress1(address1);
		this.setAddress2(address2);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setCountry(country);
		this.setLanguagePreference(language);
		this.setFavoriteCategory(category);
		
	}
	
	public WebElement getLogoImg() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("logo_img")));
	}
	
	public boolean isRegistrationSuccessful() {
		boolean displayed = false;
		if (this.getLogoImg().isDisplayed()) {
			displayed = true;
		}
		return displayed;
	}
}
