package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPage {
	
	private WebDriver webdriver;
	private By usernameField=By.id("username");
	private By passwordField=By.id("password");
	private By loginButton=By.cssSelector("#login button");
	
	public LoginPage(WebDriver webdriver) {
		
		this.webdriver= webdriver;
	}
	
	public void setUsername(String username) {
		
		webdriver.findElement(usernameField).sendKeys(username);
		
		
	}
	public void setPasswordField(String password) {
		
		webdriver.findElement(passwordField).sendKeys(password);
		
		
		
	}
	

	public SecureAreaPage clickTheLoginButton()
	{
		webdriver.findElement(loginButton).click();
		return new SecureAreaPage(webdriver);
	}
		

}
