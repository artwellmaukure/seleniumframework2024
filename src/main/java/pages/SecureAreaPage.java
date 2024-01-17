package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementFetch;
import pageObjects.SecureAreaPageElements;

public class SecureAreaPage {
	
	private WebDriver webdriver;
	private By statusArlet=By.id("flash");
	

	
	public SecureAreaPage(WebDriver webdriver) {
		this.webdriver=webdriver;
	}
	public String getAlertText(){
		return webdriver.findElement(statusArlet).getText();
		
		
			
		
		
		
		
	
		
		
	}
	

}
