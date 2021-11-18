package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderProductPage extends PageBAse {

	public OrderProductPage(WebDriver driver) {
		super(driver);
	}
	 String pricefromhomePg;
	 String pricefromkasse;
	@FindBy(xpath = "//*[@id=\"s-results\"]/li[1]/a/div[2]/div")
	WebElement firstProduct;

	@FindBy(xpath = "/html/body/div[2]/div/div/main/section/article/div[4]/div/div[1]/div/div[1]/div[1]/div/div/div[1]")
	WebElement pricefromhomePage;

	@FindBy(xpath = "//*[@id=\"cart-overlay__pca-overlay\"]/div[2]/div[2]/ul/li/div[3]/span/div")
	WebElement pricefromkassePage;

	@FindBy(xpath = "/html/body/div[2]/div/div/main/section/article/div[4]/div/div[3]/div/button")
	WebElement addtoCart;

	@FindBy(xpath = "//*[@id=\"cart-overlay__pca-overlay\"]/div[2]/div[2]/div[1]/button[2]")
	WebElement buymore;

	@FindBy(xpath = "//*[@id=\"cart-overlay__pca-overlay\"]/div[2]/div[2]/div[1]/button[1]")
	WebElement tocasher;


	public void selectFirstProduct() {
		firstProduct.click();
		pricefromhomePg = pricefromhomePage.getText();
		addtoCart.click();
		pricefromkasse = pricefromkassePage.getText();
		buymore.click();
	}
	
	public String getPricefromHomePage() {
		return pricefromhomePg;
	}

	public String getPricefromCart() {
		return pricefromkasse;
	}
	public void buymore() {
		buymore.click();
	}

	public void tokasse() {
		tocasher.click();
	}

}
