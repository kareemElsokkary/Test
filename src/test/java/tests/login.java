package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;

public class login extends TestBase {

	HomePage homePage;
	LoginPage  login;
	String Email = LoadProperties.userData.getProperty("Email");
	String Password = LoadProperties.userData.getProperty("Password");
	String message = LoadProperties.userData.getProperty("messageforVerifyLogin");

	
	@BeforeTest
	public void openloginPage()
	{
		homePage = new HomePage(driver);
		homePage.clickOnmyAccount();
		homePage.login();
	}
	
	@Test
	public void loginwithemailandPassword() {
		login = new LoginPage(driver);
		login.login(Email, Password);
	}
	
	@Test
	public void verifiylogin() {
		login = new LoginPage(driver);
		Assert.assertTrue(login.getverifyText().contains(message));
	}
}
