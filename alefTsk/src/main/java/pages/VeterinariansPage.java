package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VeterinariansPage extends PageBase {

	public VeterinariansPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(id = "vets")
	public WebElement tableID;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allColss;
	
	
	public void validateVeterinariansTableisDisplayed()
	{
		tableID.isDisplayed();
	}
	

}
