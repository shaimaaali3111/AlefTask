package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import utilities.Helper;

public class TestBase2 {


	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String brwoserName)
	{
		if (brwoserName.equalsIgnoreCase("chrome")) {
			String chromepath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath );
			driver = new ChromeDriver();

		}
		else if (brwoserName.equalsIgnoreCase("firefox"))
		{
			String firefoxpath = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxpath );
			driver = new FirefoxDriver();
		}

		else if (brwoserName.equalsIgnoreCase("ie"))
		{
			String iepath = System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",iepath );
			driver = new InternetExplorerDriver(); 			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8080/");
	}

	//take object from ITestresult to take all test cases result from testng
	@AfterMethod
	public void ScreenshotOnfailure(ITestResult result) 
	{
		//if result equal fail 
		if (result.getStatus()== ITestResult.FAILURE)
		{
			System.out.println("failed");
			System.out.println("Taking Screenshot...");

			//meaning take screenshot and take name of failed method 
			Helper.caputerScreenshot(driver, result.getName());

		}}



	@AfterSuite
	public void closeDriver () 
	{
		driver.quit();
	
	}
}
