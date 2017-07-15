package com.fanniemae.draft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestProperties {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		System.out.println("Project directory path: " + System.getProperty("user.dir"));

		// Using Properties Class from core Java
		Properties config = new Properties();
		Properties OR = new Properties();

		// Using FileInputStream Class from core Java
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		System.out.println("Browser used: " + config.getProperty("browser"));

		// driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		System.out.println(OR.getProperty("bmlBtn"));

		if (config.getProperty("browser").equals("firefox")) {

		    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			//log.debug("Chrome Launched !!!");
		} else if (config.getProperty("browser").equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		
		
		driver.get(config.getProperty("testsiteurl"));
		//log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		

	}

}
