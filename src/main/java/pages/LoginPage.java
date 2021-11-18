package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBAse{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="field_EmailOrPhone")
	WebElement email;
	@FindBy(id="button_btn_submit_email")
	WebElement next;
	@FindBy(id="field_Password")
	WebElement password;
	@FindBy(id="button_submit")
	WebElement submit;
	
	@FindBy(xpath = "/html/body/div[1]/div/header/div[1]/div[2]/nav/ol/li[4]/ol/li[2]/div[1]/div/div[2]")
	WebElement verify;
	public void login(String Email, String Password) {
		
		email.sendKeys(Email);
		next.click();
		password.sendKeys(Password);
		submit.click();
	}
	
	public String getverifyText() {
		return verify.getText();
	}
	
}
