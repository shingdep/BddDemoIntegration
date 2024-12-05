package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchByName {

	WebDriver gdriver;
	
	public searchByName(WebDriver rdriver) 
	{
		 gdriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	  @FindBy(xpath ="//div[@class='card-body']//h5[contains(text(), 'Elements')]")
      WebElement ClickOnElements;
	
	  @FindBy(xpath = "(//*[contains(text(),'Web Tables')])[1]")
	  WebElement clickOnWebtableMenu;
	  
	  @FindBy(id ="searchBox")
	  WebElement enterTextField;
	  
	  @FindBy(xpath = "//*[@class='input-group-append']")
	  WebElement clickOnsearchButton;
	  
	  @FindBy(xpath = "//div[@role='grid']")
	  WebElement searchData;
	  
	  @FindBy(xpath = ".//div[@role='grid']//div[@role='row']")
	  List <WebElement> totalRows;
	  
	  @FindBy(xpath = ".//div[@role='grid']//div[@role='row'][1]/div[@role='columnheader']")
	  List <WebElement> totalCols;
	  
	  public String getTitle()
	  {
		return gdriver.getTitle();
		  
	  }
	  
	  public void clickElement()
	  {
		  ClickOnElements.click();
	  }
	  
	  public void clickwebt()
	  {
		  clickOnWebtableMenu.click();
	  }
	  
	  public void enterFirstname(String name)
	  {
		  enterTextField.sendKeys(name);
	  }
	  
	  public void clicksearchBtton()
	  {
		  clickOnsearchButton.click();
	  }
	  
	  public boolean searchBynameDemo(String name1)
	  {
		  boolean found=false;
		  
		  int ttlrows=totalRows.size();
		  
		  for(int i=1; i<ttlrows; i++)
		  {
			WebElement webE = gdriver.findElement(By.xpath("(.//div[@role='grid']//div[@role='row'][1]/div[@role='columnheader'])[1]"));
		    String actResult=webE.getText();
		    
		    if(actResult.equals(name1))
		    {
		    	found=true;
		    	break;
		    }
		  }
		return found;
		  
	  }
	  
}
