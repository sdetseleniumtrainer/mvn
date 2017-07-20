package com.fanniemae.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fanniemae.base.TestBase;
import com.fanniemae.utilities.TestUtil;

public class SDET_Login_TestCase extends TestBase {

	 String DBDataInLocalArray[][]=null;
	 int numOfRows = 0;
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
		
		String UserName="xpath_User";
		String UserNameValue="Alex.good@gmail.com";
		
		String Password="id_Pwd";
		String PasswordValue="Alex123";
		
				log.debug("Inside testFrameworkSDETLogin");
				
				Assert.assertTrue(isElementPresent(By.id(OR.getProperty("id_LoginBtn"))),"Login button not present :)");
				
				
				//driver.findElement(By.id(OR.getProperty("id_LoginBtn"))).click();
				click("id_LoginBtn");
				System.out.println("id_LoginBtn clicked");
				log.debug("Clicked LoginBtn");
				//driver.findElement(By.xpath(OR.getProperty("xpath_LoginBtn"))).click();
				
				
				type(UserName,UserNameValue);
				System.out.println("typed in xpath_User");
				log.debug("Typed in xpath_User");
				
				
				type(Password,PasswordValue);
				System.out.println("typed in id_Pwd");
				log.debug("Typed in id_Pwdr");
				
				
				click("id_BottomLoginbutton");
				System.out.println("id_BottomLoginBtn clicked");
				log.debug("Clicked BottomLoginBtn");
				
				
				Thread.sleep(3000);
				
				Assert.assertEquals(getText("id_SuccessLogin"),"Welcome back!");
				
		
	}
	
	
	
	@Test(enabled=true)
	public void test_DDT_SDETLogin() throws Exception{
		
		
        FetchDBData();
		
		for(int i=0; i<numOfRows; i++){	
			
			String UserName="xpath_User";
			String Password="id_Pwd";
			String UserNameValue= DBDataInLocalArray[i][0];                  ;
			String PasswordValue=DBDataInLocalArray[i][1];  
			
			
			click("id_LoginBtn");
			type(UserName,UserNameValue);
			type(Password,PasswordValue);
			
			TestUtil.captureScreenshot();
			
			click("id_BottomLoginbutton");
			Thread.sleep(3000);
			Assert.assertEquals(getText("id_SuccessLogin"),"Welcome back!");
			
		}
		
		
	}
	
	
	
	public void FetchDBData() throws Exception{
		 
		 String connectionString=null;
		 String DBSqlServerDriver=null;
		 String sqlQuery=null;
		 
		
		
		 connectionString = "jdbc:sqlserver://sql2k801.discountasp.net:1433;databasename=SQL2008_841902_tr;user=SQL2008_841902_tr_user;password=52645264hrm";
		 DBSqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 
		 sqlQuery="select top 4 custemail, custpassword from TRCustomers order by cust_id";
		 
	 try{
			 
			 Class.forName(DBSqlServerDriver);
			 Connection oConn = DriverManager.getConnection(connectionString);
			 Statement oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 
			 ResultSet oRslt =   oStmt.executeQuery(sqlQuery);
			 
			 oRslt.last();
			 numOfRows =  oRslt.getRow();
			 
			 System.out.println("Total Records from DB: " + numOfRows);
			 oRslt.beforeFirst();
			 
			 
			 
			 DBDataInLocalArray = new String[numOfRows][2];
			 
			 int i=0;
			 while(oRslt.next()){
				 
				 System.out.println("Reading Email from DB: " + oRslt.getString("CustEmail"));
				 DBDataInLocalArray[i][0] =   oRslt.getString("CustEmail");
				 
				 System.out.println("Reading Password from DB: " + oRslt.getString("CustPassword"));
				 DBDataInLocalArray[i][1] =   oRslt.getString("CustPassword");
								
				 i=i+1;
			 }
			 
			// oRslt.close();
			// oConn.close();
			 
		 }
		 catch(Exception e){
			 System.err.println("Error occured while connecting to the DB: " + e.getMessage());
		 }
		 
		 
	 }

	
	

}
