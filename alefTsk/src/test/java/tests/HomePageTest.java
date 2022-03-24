package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;


public class HomePageTest extends TestBase2 {

	HomePage homePageObject;

	@Test (priority=1,alwaysRun=true)
	public void validateVetPic()
	{
		homePageObject = new HomePage(driver);

		Boolean pic = (Boolean) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].complete "
						+ "&& typeof arguments[0].naturalWidth != \"undefined\" "
						+ "&& arguments[0].naturalWidth > 0", homePageObject.VetiImg);

		if (pic) {
			System.out.println("Vet pic present");
		} else {
			System.out.println("Vet pic not present");
		}

	}





}










