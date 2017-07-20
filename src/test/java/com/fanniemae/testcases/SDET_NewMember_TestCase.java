package com.fanniemae.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fanniemae.base.TestBase;

public class SDET_NewMember_TestCase extends TestBase {
	
	@Test(enabled=true)
	  public void test_SDET_NewMember() throws Exception {
		//WebDriver driver;
	    driver.findElement(By.id("HeadLoginView_lblLoginStatus")).click();
	    driver.findElement(By.id("createaccount")).click();
	    driver.findElement(By.id("MainContent_txtFirstName")).clear();
	    driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Stu701");
	    driver.findElement(By.id("MainContent_txtLastName")).clear();
	    driver.findElement(By.id("MainContent_txtLastName")).sendKeys("SdetTraining");
	    driver.findElement(By.id("MainContent_Male")).click();
	    driver.findElement(By.id("MainContent_txtEmail")).clear();
	    driver.findElement(By.id("MainContent_txtEmail")).sendKeys("stu701@sdettraining.com");
	    driver.findElement(By.id("MainContent_txtPassword")).clear();
	    driver.findElement(By.id("MainContent_txtPassword")).sendKeys("Passw0rd");
	    driver.findElement(By.id("MainContent_txtVerifyPassword")).clear();
	    driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("Passw0rd");
	    driver.findElement(By.id("MainContent_txtHomePhone")).clear();
	    driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("7017017011");
	    driver.findElement(By.id("MainContent_txtCellPhone")).clear();
	    driver.findElement(By.id("MainContent_txtCellPhone")).sendKeys("7017017011");
	    driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
	    driver.findElement(By.id("MainContent_txtInstructions")).clear();
	    driver.findElement(By.id("MainContent_txtInstructions")).sendKeys("stu701@sdettraining.com");
	    driver.findElement(By.id("MainContent_btnSubmit")).click();
	    Thread.sleep(5000);
	    Assert.assertEquals(driver.findElement(By.id("MainContent_lblTransactionResult")).getText(), "Customer information added successfully");
	  }

}
