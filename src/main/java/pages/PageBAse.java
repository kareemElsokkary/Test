package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class PageBAse {
protected WebDriver driver;

	public PageBAse(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
}
