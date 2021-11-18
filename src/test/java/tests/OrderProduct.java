package tests;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.OrderProductPage;

public class OrderProduct extends TestBase {
	HomePage homePage;
	OrderProductPage orderPage;
	public  static String Price1fromHomePage, Price1fromcart;
	public  static String Price2fromHomePage, Price2fromcart;
	public  static String Price3fromHomePage, Price3fromcart;
	String P1 = LoadProperties.userData.getProperty("Product1");
	String P2 = LoadProperties.userData.getProperty("Product2");
	String P3 = LoadProperties.userData.getProperty("Product3");

	@Test
	public  void order3Products() {
		
		homePage= new HomePage(driver);
		orderPage = new OrderProductPage(driver);
		
		homePage.search(P1);
		orderPage.selectFirstProduct();
		Price1fromHomePage= orderPage.getPricefromHomePage();
		Price1fromcart=orderPage.getPricefromCart();
		homePage.search(P2);
		orderPage.selectFirstProduct();
		Price2fromHomePage= orderPage.getPricefromHomePage();
		Price2fromcart=orderPage.getPricefromCart();
		homePage.search(P3);
		orderPage.selectFirstProduct();
		Price3fromHomePage= orderPage.getPricefromHomePage();
		Price3fromcart=orderPage.getPricefromCart();
	}
	
}
