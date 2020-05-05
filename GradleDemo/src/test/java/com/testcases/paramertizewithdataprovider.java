package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class paramertizewithdataprovider {
	WebDriver driver;
	@Test (dataProvider="facebooklogin")
	public void loginToWordpress(String username,String password) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shivshankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	    
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("pass")).sendKeys(password);
	   // driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	    
	    Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
	    System.out.println(driver.getCurrentUrl());
	    System.out.println("user is able to login successfully");

	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider(name="facebooklogin")
	public Object[][] passData(){
		
		Object[][] data =new Object[3][2];
		//username
		data[0][0]="Geethu";
			//password
			data[0][1]="demo1";
			
			data[1][0]="Keerthi";
			data[1][1]= "demo123";
			
			data[2][0]="Aaradhana";
			data[2][1]="demo456";
			
			return data;
			
		
	}
	

}
