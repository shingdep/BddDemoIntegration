package StepDef;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.ClickCheckBox;
import Pom.LoginDemo;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef1 
{
	
	public WebDriver driver;
	public LoginDemo ld;
	
	
	@Given("User launches browser")
	public void user_launches_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    ld=new LoginDemo(driver);
	   
	}

	@When("User opens url as {string}")
	public void user_opens_url_as(String url) {
	  driver.manage().window().maximize();
	  driver.get(url);
	}
	
	@When("User enters Username as {string} and Password as {string}")
    public void user_enters_username_as_and_password_as(String addname, String addpass) {
           ld.enteruname(addname);
           ld.enterpassw(addpass);
    }

	@When("Clicking on login button")
	public void clicking_on_login_button() {
	    ld.clickLoginBtton();
	    
	}

	@Then("Page redirects to homepage and Page title should be displayed as {string}.")
	public void page_redirects_to_homepage_and_page_title_should_be_displayed_as(String expTitle) 
	{
	    String actualRes=driver.getTitle();
	    if(actualRes.equals(expTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	

	@Then("Close browser")
	public void close_browser() throws InterruptedException {
		Thread.sleep(3000);
	   driver.close();
	}

	
}
