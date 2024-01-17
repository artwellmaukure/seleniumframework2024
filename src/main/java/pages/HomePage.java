package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePage {
	private WebDriver webdriver;
	
	
	private By formAuthenticationLink=By.linkText("Form Authentication");
	
	public HomePage(WebDriver webdriver) {
	this.webdriver=webdriver;
		
	}
	
	public LoginPage clickFormAuthentication() {
		webdriver.findElement(formAuthenticationLink).click();
		
	
	
	
		
		
		return new LoginPage(webdriver);
	
	}

}
