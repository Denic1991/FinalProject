package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private Properties locators;
	private WebDriverWait waiter;
	
	public CartPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}

	public WebElement getQuantuty() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("quantity")));
	}

	public void setQuantity(String quantity) {
		this.getQuantuty().clear();
		this.getQuantuty().sendKeys(quantity);
	}
	
	public WebElement getRemoveButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("remove_button")));
	}
	
	public void clickRemoveButton() {
		this.getRemoveButton().click();	
	}
	
	public WebElement getCheckout() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("procced_to_checkout")));
	}
	
	public void clickCheckout() {
		this.getCheckout().click();
	}
	
	public List<WebElement> getItemsID() {
		return this.driver.findElements(By.xpath(this.locators.getProperty("item_ID")));	
	}
	
	public WebElement getItemsTotalCost() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("total_cost")));
	}
	
	public boolean checkIsItemInCart(String ID) {
		boolean inCart = false;
		List<WebElement> items = this.getItemsID();
		for (int i = 0; i < items.size(); i++) {
			String item = items.get(i).getText();
			if (item.contentEquals(ID)) {
				inCart = true;
			}
		}
		return inCart;
		
	}
	

}
