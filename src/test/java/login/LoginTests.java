package login;
import org.testng.Assert;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import base.BaseTest;
//import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;



public class LoginTests extends BaseTest {
	 
	
	String expectedText="You logged into a secure area!x";
	

	@Test
	public void testSuccessfulLogin() {
		LoginPage loginpage=homepage.clickFormAuthentication();
		loginpage.setUsername("tomsmith");
		loginpage.setPasswordField("SuperSecretPassword!");
		SecureAreaPage securepage=loginpage.clickTheLoginButton();
		String actualText=securepage.getAlertText();
		
		
		assertTrue(actualText.contains("Artwell"));
		//You logged into a secure area
		
		
		
	}

}

