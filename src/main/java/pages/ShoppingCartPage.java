package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBAse {

//	public String Price1FromCartPage;
//	public String totalPriceFromCartPage;
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//*[@id=\"cartItems_cartsection\"]/div[3]/div/div[1]/div[4]/div[2]/div/div/div/div")
	WebElement price1;
	
	@FindBy(xpath = "//*[@id=\"cartItems_cartsection\"]/div[2]/div/div[1]/div[4]/div[2]/div/div/div/div")
	WebElement price2;
	
	@FindBy(xpath = "//*[@id=\"cartItems_cartsection\"]/div[1]/div/div[1]/div[4]/div[2]/div/div/div/div")
	WebElement price3;
	
	@FindBy(xpath = "//*[@id=\"-subtotal\"]/div/div[2]")
	WebElement subtotal;
	
	@FindBy(xpath = "//*[@id=\"-shipping-cost-after-coupon\"]/div/div[2]")
	WebElement shipping;
	
	@FindBy(xpath = "//*[@id=\"-total\"]/div/div[2]")
	WebElement totalPrice;
	
	@FindBy(xpath = "/html/body/div[2]/div/main/div/section/div[2]/div[3]/div/div[1]")
	WebElement additionsshippingcost;
	
	public boolean additionalcost() {
		return additionsshippingcost.isDisplayed();
	}
	public String getThePrice(String Price)
	{
		
		  switch(Price){
		  case "Price1":
	            return price1.getText();
	            
		  case "Price2":
	            return price2.getText();
		  case "Price3":
	            return price3.getText(); 
	            
		  case "Subtotal":
	            return subtotal.getText();      
	    
		  case "Shipping":
	            return shipping.getText();      
	    
		  case "TotalPrice":
	            return totalPrice.getText();      
	        
	        }
		return Price;
	}
	

}
