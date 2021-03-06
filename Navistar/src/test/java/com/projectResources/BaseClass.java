package com.projectResources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class BaseClass{
	static Properties prop;
	static WebDriver driver;

	public static String readProperty(String Key) {
		String path=System.getProperty("user.dir")+"//src//test//resources//Config.properties";
		File file = new File(path);

		 FileInputStream fileInput = null;
		try {
		fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		prop = new Properties();

		 // load properties file
		try {
		prop.load(fileInput);
		} catch (IOException e) {
		e.printStackTrace();

		 }
		String value = prop.getProperty(Key);
		System.out.println("Value fetched form the conig.properties file " + Key + " = " + value);
		return value;
		}
	public static WebDriver launchBrowser(String browsername)
	{
		if(browsername.equals("Mozilla"))
		{   
			System.out.println("browser is opening" +browsername);
			String path=System.getProperty("user.dir")+"//src//test//resources//Drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",path);
			
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equals("Edge"))
		{
			System.out.println("browser is opening" +browsername);
			String path=System.getProperty("user.dir")+"//src//test//resources//Drivers//msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",path);
		
		
			driver=new EdgeDriver();	
			
			
	     }
		else if(browsername.equals("Chrome"))
		{
			System.out.println("browser is opening" +browsername);
			String path=System.getProperty("user.dir")+"//src//test//resources//Drivers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",path);
		
			driver=new ChromeDriver();			
			
	     }
		else if(browsername.equals("Internet_Explorer"))
		{
			System.out.println("browser is opening" +browsername);
			String path=System.getProperty("user.dir")+"//src//test//resources//Drivers//IEdriverServer.exe";
			System.setProperty("webdriver.gecko.driver",path);
		
			driver=new ChromeDriver();			
			
	     }
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;	

	}
	
	/******** Generic_Keywords*******************/
	public void click(WebElement element)
	{
		System.out.println("clicking on---"+element);
		element.click();
		
	}
	public void type(WebElement element, String data)
	{
		String enter_name=BaseClass.readProperty(data);
		System.out.println("typing in--"+element+".Data"+enter_name);
		element.sendKeys(enter_name);
	
	}
	/************Validation_Key***************************/
	public boolean verifyLogin_Labal(String expectedKey, WebElement element)
	{
		
		String expected=BaseClass.readProperty(expectedKey);
		String label=element.getText();
		
		if(expected.equals(label))
			{System.err.println("valid login----"+label);
			return true;
			}
		
		else
			return false;
			
	}
	
	/*public WebElement getElement(WebElement element)
	{
		//check the presence
		if(!isElementPresent(element))
		//report failure
			System.out.println("element is not presence--");

		
		//check the visibility
				if(!isElementVisible(element))
				{//report failure
					System.out.println("element is not visible--");
				}
				else
					System.out.println("locator is visible--");
				//extract the element
				
				return element;
				
	}
	public boolean isElementPresent(WebElement element)
	{
		System.out.println("check presence of locator--");
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.invisibilityOf(element));
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean isElementVisible(WebElement element)
	{
		System.out.println("check visibility of locator--");
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}*/
	
	
	

	
	


}
