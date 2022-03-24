package tests;



import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.OwnersPage;


public class OwnersTest extends TestBase2 {


	OwnersPage ownerPageObject;
	HomePage homePageObject;
	
	

	@Test (priority=1,alwaysRun=true)
	public void clickOnOwnersButton() {

		homePageObject = new HomePage(driver);
		homePageObject.clickOnOwnersBtn();
	}
	
	

	@Test (priority=2,alwaysRun=true)
	public void clickOnFindOwnerButton() {

		ownerPageObject = new OwnersPage(driver);
		ownerPageObject.clickFindOnOwnersBtn();
	}
	
	
	


	@Test (priority=3,alwaysRun=true,enabled = true)
	public void getAllOwners() {

		ownerPageObject = new OwnersPage(driver);

		List<String> nameList= new ArrayList<String>();

		//get pagination size
		int sizePagenation= driver.findElements(By.xpath("/html/body/div/div/div/span/a")).size();
		System.out.println(sizePagenation);

		System.out.println("____________");

		

		//get all owners 
		WebElement webTable = driver.findElement(By.id("owners"));
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));

		for(int rnum=1;rnum<rows.size();rnum++) {
			List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
			System.out.println(columns.get(0).getText());
		}

		for (int i =4; i<=sizePagenation;i++)
		{

			String pagenationSelector ="/html/body/div/div/div/span["+i+"]/a";

			driver.findElement(By.xpath(pagenationSelector)).click();
			List<WebElement>namesElements=driver.findElements(By.cssSelector("#owners >tbody >tr >td:nth-child(1)"));

			for (WebElement namesElement : namesElements) {
				nameList.add(namesElement.getText());
			}
		}
		for (String name : nameList) { 
			System.out.println(name);
		}

		System.out.println("____________");

	}




	@Test (priority=4,alwaysRun=true)
	public void clickOnAddOwnersButton() {
		
		String ownerName="shaimaa";
		String lastName="ali";
		String address="egypt";
		String city="cairo";
		String mobile= "1100542775";
		

		ownerPageObject = new OwnersPage(driver);

		homePageObject.clickOnOwnersBtn();
		ownerPageObject.clickAddOnOwnersBtn();
		ownerPageObject.addNewOwner(ownerName, lastName, address, city, mobile);
		ownerPageObject.clickSubmitOwnersBtn();
		
		WebElement webTable = driver.findElement(By.xpath("//table[@class='table table-striped'][1]"));
		List<WebElement> cols = webTable.findElements(By.tagName("td"));

		//assert the data added successfully 
		String fName =cols.get(0).getText();
		System.out.println(fName);
		assertEquals(ownerName+" "+lastName, fName);

		String country =cols.get(1).getText();
		System.out.println(country);
		assertEquals(address, country);
		
		String cityName =cols.get(2).getText();
		System.out.println(cityName);
		assertEquals(city, cityName);
		
		String mob =cols.get(3).getText();
		System.out.println(mob);
		assertEquals(mobile, mob);
		
		System.out.println("+++++++++");


	}
	
	
	

	@Test (priority=5,alwaysRun=true)
	public void clickOnAddNewPet() throws InterruptedException {
		String pet ="cezer";
		String birhtdate ="09252013";
		String type ="dog";

		ownerPageObject = new OwnersPage(driver);

		ownerPageObject.clickOnAddNewPetBtn();

		ownerPageObject.fillPetName(pet);
		ownerPageObject.openBirthdayForm(birhtdate);

		ownerPageObject.selectPetType(type);

		Thread.sleep(2000);
		ownerPageObject.clickSubmitNewBtn();
		

		//Assert all the information added for the newly created owner is correct
		WebElement webTable = driver.findElement(By.xpath("//table[@class='table table-striped'][1]"));
		List<WebElement> cols = webTable.findElements(By.tagName("td"));

		StringBuilder X=new StringBuilder();  
		for (WebElement col : cols) {
			X.append(col.getText());
			X.append("\n");
			System.out.println(col.getText());
		}

		System.out.println("*********");
		

		String expectedtableData="""
				shaimaa ali
				egypt
				cairo
				1100542775
				""";

		System.out.println(X);		      
		Assertion softAssert = new SoftAssert();
		softAssert.assertEquals(expectedtableData, X);
		
		



		//Assert all the information added for the newly pet is correct
		WebElement petTable = driver.findElement(By.xpath("//table[@class='table table-striped'][2]"));
		List<WebElement> colss = petTable.findElements(By.tagName("dd"));     

		String Name =colss.get(0).getText();
		System.out.println(Name);
		assertEquals(pet, Name);

		String date =colss.get(1).getText();
		System.out.println(date);
		assertEquals("2013-09-25", date);

		String petType =colss.get(2).getText();
		System.out.println(petType);
		assertEquals(type, petType);


	}


}
