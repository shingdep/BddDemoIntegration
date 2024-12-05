package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickCheckBox 
{
	WebDriver ldriver;

	public ClickCheckBox(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath ="//div[@class='card-body']//h5[contains(text(), 'Elements')]")
	WebElement ClickOnElements;

	@FindBy(xpath="(//*[contains(text(),'Check Box')])[1]")
	WebElement ClickCheckboxMenu;

	@FindBy(xpath = "(//*[contains(text(),'Home')])[1]")
	WebElement ClickCheckbox1;

	public String getTitle()
	{
		return ldriver.getTitle();

	}


	public void clickElement()
	{
		ClickOnElements.click();
	}

	public void ClickchkboxMenu() 
	{
		ClickCheckboxMenu.click();
	}

	public void clickChkBox()
	{
		ClickCheckbox1.click();
	}


}
