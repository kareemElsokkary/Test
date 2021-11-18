package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;

import pages.ShoppingCartPage;

public class VerifyPrice extends TestBase {

	HomePage homepage;
	ShoppingCartPage sc;

	String P1 = LoadProperties.userData.getProperty("Product1");
	String P2 = LoadProperties.userData.getProperty("Product2");
	String P3 = LoadProperties.userData.getProperty("Product3");
	String Shippingcost = LoadProperties.userData.getProperty("Shipping");
	String totalPrice;
	float expectedtotalPrice;
	String Price1FromShoppingCart,Price2FromShoppingCart,Price3FromShoppingCart;
	String ShippingPriceFromShoppingCart,SubtotalFromShoppingCart,TotalPriceFromShoppingCart;	
	@BeforeTest
	private void order() {

		OrderProduct o = new OrderProduct();
		o.order3Products();
	}
	@Test
	public void openShoppincart() {
		homepage = new HomePage(driver);
		homepage.clickonshoppingcart();
	}

	@Test(dependsOnMethods = "openShoppincart")
	public void getthePricesfromShoppingCart() {

		sc = new ShoppingCartPage(driver);

		Price1FromShoppingCart= sc.getThePrice("Price1");
		Price2FromShoppingCart= sc.getThePrice("Price2");
		Price3FromShoppingCart= sc.getThePrice("Price3");
		SubtotalFromShoppingCart= sc.getThePrice("Subtotal");
		ShippingPriceFromShoppingCart= sc.getThePrice("Shipping");
		TotalPriceFromShoppingCart= sc.getThePrice("TotalPrice");
		totalPrice = TotalPriceFromShoppingCart.substring(0, TotalPriceFromShoppingCart.length()-11);


		System.out.println("The Price of " + P1 +" :" + Price1FromShoppingCart+ " €" );
		System.out.println("The Price of " + P2 +":" + Price2FromShoppingCart+ " €" );
		System.out.println("The Price of " + P3 +":" + Price3FromShoppingCart+ " €" );
		System.out.println("Subtotal :" + SubtotalFromShoppingCart + " €" );
		System.out.println("Shipping :" + ShippingPriceFromShoppingCart + " €" );
		System.out.println("TotalPrice :" + TotalPriceFromShoppingCart + " €" );


	}

	@Test(dependsOnMethods = "getthePricesfromShoppingCart")
	public void verifiytheprice() {
		sc = new ShoppingCartPage(driver);
		Assert.assertEquals(Price1FromShoppingCart, OrderProduct.Price1fromcart);
		Assert.assertEquals(Price1FromShoppingCart, OrderProduct.Price1fromHomePage);
		Assert.assertEquals(Price2FromShoppingCart, OrderProduct.Price2fromcart);
		Assert.assertEquals(Price2FromShoppingCart, OrderProduct.Price2fromHomePage);
		Assert.assertEquals(Price3FromShoppingCart, OrderProduct.Price3fromcart);
		Assert.assertEquals(Price3FromShoppingCart, OrderProduct.Price3fromHomePage);

		float expectedsubtotalPrice =  Float.parseFloat(Price1FromShoppingCart)+ Float.parseFloat(Price2FromShoppingCart)+ Float.parseFloat(Price3FromShoppingCart);

		if(sc.additionalcost())
		{

			expectedtotalPrice = (float) (expectedsubtotalPrice + Float.parseFloat(Shippingcost) + 19.95);
		}
		else 
		{
			expectedtotalPrice = (float) (expectedsubtotalPrice + Float.parseFloat(Shippingcost) );

		}

		Assert.assertEquals(Float.parseFloat(SubtotalFromShoppingCart), expectedsubtotalPrice);
		Assert.assertEquals(ShippingPriceFromShoppingCart, Shippingcost);
		Assert.assertEquals(Float.parseFloat(totalPrice), expectedtotalPrice);



	}
}
