package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;




public class TestBase 
{
	public static WebDriver driver ; 

	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browser) {

		if(browser.equalsIgnoreCase("chrome"))
		{
			String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);	
			driver = new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("chrome-headless"))
		{
			String chromePath2 = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath2);	
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);

		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String Path = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", Path);	
			driver = new FirefoxDriver();

		}
		
		else if(browser.equalsIgnoreCase("headless"))
		{
			String Path = System.getProperty("user.dir") + "\\drivers\\phantomjs.exe";
			
		DesiredCapabilities des = new DesiredCapabilities();
		des.setJavascriptEnabled(true);
		des.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Path);
		String[] phantomJsArgument = {"--webdriver-loglevel=NONE","--web-security=no","--ignore-ssl-errors=yes"};
		des.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgument);
			driver = new PhantomJSDriver(des);

		}
		driver.navigate().to("https://www.lidl.de/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.className("cookie-alert-extended-button")).click();
	}

	@AfterSuite

	public void quitDriver() {

		//	driver.quit();
	}




}
