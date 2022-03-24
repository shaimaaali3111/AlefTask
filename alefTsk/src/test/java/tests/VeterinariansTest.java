package tests;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.VeterinariansPage;

public class VeterinariansTest extends TestBase2 {

	VeterinariansPage veterinariansPageObject;
	HomePage homePageObject;

	@Test (priority=1,alwaysRun=true)
	public void clickOnVeterinarians() {

		homePageObject = new HomePage(driver);
		homePageObject.clickOnVeterinariansBtn();	
	}




	@Test (priority=2,alwaysRun=true)
	public void getAllVeterinarians()

	{
		veterinariansPageObject = new VeterinariansPage(driver);

		//select all veterinarians

		veterinariansPageObject.validateVeterinariansTableisDisplayed();
		List<WebElement> rows = veterinariansPageObject.tableID.findElements(By.tagName("tr"));

		for(int rnum=1;rnum<rows.size();rnum++) {
			List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
			System.out.println(columns.get(0).getText());
		}
		

        //get all table
		//		veterinariansPageObject.validateVeterinariansTableisDisplayed();
		//		
		//		assertEquals(6,veterinariansPageObject.allRows.size() );
		//		
		//		for (WebElement row :veterinariansPageObject.allRows ) {
		//			
		//			List<WebElement> cols=row.findElements(By.tagName("td"));
		//			
		//			for (WebElement col : cols) {
		//				System.out.println(col.getText()+"\t");
		//			}
		//			
		//			System.out.println();
		//		}
		//		
		//		
		//		
	}

}
