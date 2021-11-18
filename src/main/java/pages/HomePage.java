package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBAse {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"__layout\"]/div/div[1]/div/header/div[1]/div[2]/nav/ol/li[4]/ol/li[1]/a/span[2]")
	WebElement myAccount;
	public void clickOnmyAccount() {
		myAccount.click();

	}
	
	@FindBy(xpath = "/html/body/div[1]/div/header/div[1]/div[2]/nav/ol/li[6]/ol/li[1]/a")
	WebElement shppingcart;
	public void clickonshoppingcart() {
		shppingcart.click();

	}
	

	@FindBy(id="button_welcome_login")
	WebElement login;
	public void login() {
		login.click();
	}

	@FindBy(id="button_welcome_register")
	WebElement register;
	public void register() {
		register.click();
	}

	@FindBy(id="s-search-input-field")
	WebElement search;
	@FindBy(xpath = "//*[@id=\"search-input-hook\"]/form/button[1]")
	WebElement submit;

	public void search(String Product) {
		search.sendKeys(Product);
		search.submit();
		
		
	}



}
