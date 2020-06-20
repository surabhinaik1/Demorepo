package com.subhi;

import java.io.File;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScreenShotEx {

WebDriver dr;
	
	@BeforeSuite
	  public void beforeMethod() {
		  	System.setProperty("webdriver.chrome.driver", "C:/chromedriver81.exe");
			dr = new ChromeDriver();
			dr.get("file:///D:/jbk/Offline%20Website/index.html");
			dr.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
			
						
	}
	  
	 @AfterSuite
	  public void afterMethod() {
		  dr.close();
	  }
	
	 @Test
	 public void Scrnshot() throws Exception{
		 TakesScreenshot ts = (TakesScreenshot)dr;
		 
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 
		 File dest = new File(System.getProperty("user.dir")+"/screenshot/logo.jpg");
		 System.out.println(System.getProperty("user.dir"));
		 FileUtils.copyFile(src, dest);
		 
		 
	 }
}
