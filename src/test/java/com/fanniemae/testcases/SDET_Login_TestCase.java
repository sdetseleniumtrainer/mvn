package com.fanniemae.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fanniemae.base.TestBase;

public class SDET_Login_TestCase extends TestBase {

	//WebDriver driver;

	
	@Test(enabled=false)
	public void testBeginnerSDETLogin() throws Exception {
		System.setProperty("webdriver.firefox.marionette", "c:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://sdettraining.com/trguitransactions/default.aspx?id=new");
		driver.findElement(By.id("HeadLoginView_lblLoginStatus")).click();
		driver.findElement(By.id("MainContent_txtUserName")).clear();
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("irfan@sdettraining.com");
		driver.findElement(By.id("MainContent_txtPassword")).clear();
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("Password");
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("#MainContent_lblid > h1")).getText(), "Welcome back!");
		driver.quit();
	}
	
	
	
	@Test(enabled=false)
	public void testFrameworkSDETLogin() throws InterruptedException{
		//driver.findElement(By.xpath("//*[@id='HeadLoginView_lblLoginStatus']")).click();
		log.debug("Inside testFrameworkSDETLogin");
		
		Assert.assertTrue(isElementPresent(By.id(OR.getProperty("id_LoginBtn"))),"Login button not present :)");
		
		
		driver.findElement(By.id(OR.getProperty("id_LoginBtn"))).click();
		log.debug("Clicked LoginBtn");
		//driver.findElement(By.xpath(OR.getProperty("xpath_LoginBtn"))).click();
		Thread.sleep(3000);
		System.out.println("Browser opened!!!!");
	}
	
	
	@Test(enabled=true)
	public void testKWDFrameworkSDETLogin() throws InterruptedException{
		//driver.findElement(By.xpath("//*[@id='HeadLoginView_lblLoginStatus']")).click();
		log.debug("Inside testFrameworkSDETLogin");
		
		Assert.assertTrue(isElementPresent(By.id(OR.getProperty("id_LoginBtn"))),"Login button not present :)");
		
		
		//driver.findElement(By.id(OR.getProperty("id_LoginBtn"))).click();
		click("id_LoginBtn");
		System.out.println("id_LoginBtn clicked");
		log.debug("Clicked LoginBtn");
		//driver.findElement(By.xpath(OR.getProperty("xpath_LoginBtn"))).click();
		
		
		type("xpath_User","stu701@sdettraining.com");
		System.out.println("typed in xpath_User");
		log.debug("Typed in xpath_User");
		
		
		Thread.sleep(3000);
		//System.out.println("Browser opened!!!!");
	}
	
	
	
	
	
	
	
	
	
	

}
