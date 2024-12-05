package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemo 
{
       WebDriver gdriver;
       
       public LoginDemo(WebDriver rdriver)
       {
    	   gdriver=rdriver;
    	   PageFactory.initElements(rdriver, this);
       }
       
       @FindBy(id ="user-name")
       WebElement username;
       
       @FindBy(id ="password")
       WebElement Password;
       
       @FindBy(id ="login-button")
       WebElement ClickLoginB;
       
       /*public String gettitle()
       {
		return gdriver.getTitle();
    	   
       }*/
       
       public void enteruname(String Username)
       {
    	   username.sendKeys(Username);
       }
       
       public void enterpassw(String passwd)
       {
    	   Password.sendKeys(passwd);
       }
       
       public void clickLoginBtton()
       {
    	   ClickLoginB.click();
       }
       
       
       
}
