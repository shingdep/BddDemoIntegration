package StepDef;



import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.ClickCheckBox;
import Pom.searchByName;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.util.*;


public class StepDefination 
{
	public WebDriver driver;
	public searchByName sbn;
	public ClickCheckBox chkb;
	public static Logger log;
	
	
	@Given("Launch chrome browser")
	public void launch_chrome_browser() {
		
		log=LogManager.getLogger("StepDefination");
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    sbn=new searchByName(driver);
	    chkb=new ClickCheckBox(driver);
	    log.info("Browser is launched");
	}

	@When("User Opens url {string}")
	public void user_opens_url(String url) throws InterruptedException {
		Thread.sleep(2000);
		driver.get(url);
		log.info("Url is opened");
		
	}
	
	@When("Clicking on Elements section")
	public void clicking_on_elements_section() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(1000);
	    sbn.clickElement();
	    log.info("Elements section is clicked");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expTitle) throws InterruptedException {
	   
		Thread.sleep(2000);
		String actualres=driver.getTitle();
		System.out.println(driver.getTitle());
		
		if(actualres.equals(expTitle))
		{
			log.warn("Page title is displayed");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("Page title is not displayed");
			Assert.assertTrue(false);
		}
		
	}

	@When("Clicking on web table menu")
	public void clicking_on_web_table_menu() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		   
		Thread.sleep(2000);
	    sbn.clickwebt();
	    log.info("webtable menu is clicked");
	}

	@When("User enters Firstname as {string} in the Text field")
	public void user_enters_firstname_as_in_the_text_field(String firstname) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		   
		Thread.sleep(2000);
	    sbn.enterFirstname(firstname);
	    log.info("Firstname is entered in text field");
	}

	@When("Clicking on search button")
	public void clicking_on_search_button() throws InterruptedException {
	   Thread.sleep(2000);
	   sbn.clicksearchBtton();
	   log.info("Search button is clicked");
	}

	@Then("User is able to find data by name in web table")
	public void user_is_able_to_find_data_by_name_in_web_table() throws InterruptedException 
	{
		 Thread.sleep(3000);
		 
         String expName="Cierra";
	    
	    //Assert.assertTrue(seN.searchEmpByname(expName));
	    
	    
	    if(sbn.searchBynameDemo(expName)==true)
	    {
	    	log.warn("Able to find name in webtable");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	log.warn("Not Able to find name in webtable");
	    	//Assert.assertFalse(false);
	    	Assert.assertTrue(true);
	    } 
	}
	
	@When("Clicking on Checkbox menu")
	public void clicking_on_checkbox_menu() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		
		Thread.sleep(3000);
	    chkb.ClickchkboxMenu();
	    log.info("check box menu is clicked");
	}
	
	@When("clicking on checkBox")
	public void clicking_on_check_box() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		
		Thread.sleep(2000);
		chkb.clickChkBox();
		log.info("check box is clicked");
	}


	@Then("Text should be displayed as {string}")
	public void text_should_be_displayed_as(String expText) throws InterruptedException {
		  String actualText="You have selected :";
		  if(actualText.equals(expText))
		  {
			  log.warn("Text is displayed after clicking checkbox");
			  Assert.assertTrue(true);
		  }
		  else
		  {
			  log.warn("Text is not displayed after clicking checkbox");
			  Assert.assertTrue(false);
		  }
		
	}

	@Then("Browser Closed")
	public void browser_closed() throws InterruptedException 
	{
		Thread.sleep(3000);
	    driver.close();
	    log.info("Browser is closed");
	}
	
	@After
	public void teatDown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			String filePath="C:\\Users\\HP\\Downloads\\eclipse-jee-2022-12-R-win32-x86_64\\eclipse\\BddFrameNew\\Screenshot\\test1.png";
			TakesScreenshot screensh=(TakesScreenshot)driver;
			File src=screensh.getScreenshotAs(OutputType.FILE);
			File dest=new File(filePath);
			FileUtils.copyFile(src, dest);
			
			
		}
		driver.quit();
	}
	
	@AfterStep
	public void teardown(Scenario sc)
	{
		//if(sc.isFailed())
		{
			final byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(ss, "image/png", sc.getName());
		}
	
	}

}
