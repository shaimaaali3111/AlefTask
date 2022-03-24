package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(className ="img-responsive")
	public WebElement VetiImg;
	
	@FindBy(css ="a[title='veterinarians']")
	 WebElement veterinariansButton;	
	
	
	@FindBy(css ="a[title='find owners']")
	 WebElement ownersButton;
	
	
	
	
	
	public void clickOnVeterinariansBtn() {
		
		clickButton(veterinariansButton);
	}
	
    public void clickOnOwnersBtn() {
		
		clickButton(ownersButton);
	}
	
	
	
	
	

  

}
