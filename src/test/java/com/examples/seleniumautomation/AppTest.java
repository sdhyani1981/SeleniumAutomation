package com.examples.seleniumautomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.junit.Before;

/**
 * Amazon Login feature test
 */
public class AppTest 
{
    private static final String ErrorMessage = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
    private static final String Title = "Facebook - Log In or Sign Up";
    WebDriver driver = null;
    
    @Before
    public void setUp() {
    	 System.setProperty("webdriver.chrome.driver", "chromedriver");
     	 driver = new ChromeDriver();
    }

	/**
     * Invalid Login Credentials
     */
    //@Test
    public void invalidLoginCredentialsTest()
    {
    	
    	
    	driver.get("http://facebook.com");
        Assert.assertEquals(Title, driver.getTitle());
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("AaSsDFG21wer");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(ErrorMessage, driver.findElement(By.xpath("//*[@id='email_container']/div[2]")).getText());
        driver.close();
    }
    
    /**
     * Invalid Login Credentials
     */
    @Test
    public void selectBabyFromProductCategoriesDropDown()
    {
    	String dropDownText = "Baby";
    	
    	driver.get("http://amazon.com");
    	WebElement staticDropDown = driver.findElement(By.id("searchDropdownBox"));
    	Select dropdown = new Select(staticDropDown);
    	dropdown.selectByVisibleText(dropDownText);
 
    	Assert.assertEquals(dropDownText, dropdown.getFirstSelectedOption().getText());
        driver.close();
    }
}
