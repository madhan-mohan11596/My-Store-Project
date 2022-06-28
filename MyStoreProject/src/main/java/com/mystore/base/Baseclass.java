package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	
	@BeforeSuite(groups= {"Sanity","Smoke","Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		Log.info("this is before suite method");
	}


	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getdriver() {
		 return driver.get();
		
	}

	
	@BeforeTest(groups= {"Sanity","Smoke","Regression"})
	public static void loadconfig(){
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") +"//Configuration//config.Properties");
			prop.load(ip);
			System.out.println("driver :" + driver);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public static void launchapp(String browserName){
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
		
		//String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			driver.set(new ChromeDriver());
			

			
		}else if(browserName.contains("FireFox")){
			driver.set(new FirefoxDriver());
			


		}else if(browserName.contains("edge")) {
			driver.set(new EdgeDriver()); 
		


		}
		
		getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getdriver().manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS );

		getdriver().get(prop.getProperty("url"));
	}
	@AfterSuite(groups= {"Sanity","Smoke","Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
