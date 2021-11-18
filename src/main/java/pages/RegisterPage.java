package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBAse {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="field_Email")
	WebElement email;

	@FindBy(id="field_ConfirmEmail")
	WebElement confirmemail;

	@FindBy(id="field_Password")
	WebElement password;

	@FindBy(xpath = "/html/body/div/form/div/section/div/div/div[1]/div/button")
	WebElement submit;
	
	@FindBy(xpath="/html/body/div/form/div/section/div/div/div[2]/div/div/div[1]/p")
	WebElement verify;
	
	
	

	public void registerNewUser(String Email, String Pass) {

		email.sendKeys(Email);
		confirmemail.sendKeys(Email);
		password.sendKeys(Pass);
		submit.click();
	}
	
	public String getverifyText() {
		return verify.getText();
	}

}
