package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OwnersPage extends PageBase {

	public OwnersPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css ="button[type='submit']")
	 WebElement findOwnersBtn;
	
	@FindBy(linkText = "Add Owner")
	 WebElement addOwnersBtn;
	
	@FindBy(id = "firstName")
	 WebElement firsNameField;
	
	@FindBy(id = "lastName")
	 WebElement lastNameField;
	
	@FindBy(id = "address")
	 WebElement addressField;
	
	@FindBy(id = "city")
	 WebElement cityField;
	
	@FindBy(id = "telephone")
	 WebElement telephoneField;
	
	@FindBy(xpath = "//button[contains(text(),'Add Owner')]")
	 WebElement submitNewOwner;
	
	@FindBy(linkText = "Add New Pet")
	 WebElement addNewPetBtn;
	
	@FindBy(id = "name")
	 WebElement petNameField;
	
	@FindBy(id = "birthDate")
	 WebElement birthDateDatePicker;
	
	@FindBy(id = "type")
	 WebElement typeDropdownList;
	
	@FindBy(xpath = "//button[contains(text(),'Add Pet')]")
	 WebElement submitNewPet;
	
	
	
	
	
	

	
	
	
public void clickFindOnOwnersBtn() {
		
		clickButton(findOwnersBtn);
	}

public void clickAddOnOwnersBtn() {
	
	clickButton(addOwnersBtn);
}

public void addNewOwner(String firstName, String lastName, String address , String city, String telehone ) {
	setTextelementtext(firsNameField, firstName);
	setTextelementtext(lastNameField,lastName );
	setTextelementtext(addressField, address);
	setTextelementtext(cityField, city);
	setTextelementtext(telephoneField, telehone);
}

public void clickSubmitOwnersBtn() {
	
	clickButton(submitNewOwner);
}

public void clickOnAddNewPetBtn() {
	
	clickButton(addNewPetBtn);
}

public void fillPetName(String name) {
	
	setTextelementtext(petNameField, name);
}

public void openBirthdayForm(String birthdate){
	
	setTextelementtext(birthDateDatePicker,birthdate);
}

public void selectPetType(String value) {
	
	Select valueDropdown=new Select(typeDropdownList);
	valueDropdown.selectByValue(value);
}

public void clickSubmitNewBtn() {
	
	clickButton(submitNewPet);
}



}
