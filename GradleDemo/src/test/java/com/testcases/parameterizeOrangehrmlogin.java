package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parameterizeOrangehrmlogin {
	WebDriver driver;
	Select menu;
	@Test (dataProvider="orangedemologin")
	public void loginToWordpress(String username,String password) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shivshankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	    
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
//	    driver.findElement(By.id("searchSystemUser_userName")).sendKeys("George");
//	    menu= new Select(driver.findElement(By.id("searchSystemUser_userType")));
//		menu.selectByVisibleText("Admin");
//		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Washington");
//		menu.selectByVisibleText("Enabled");
//		driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
//	    
	    
	    Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl());
	    System.out.println(driver.getCurrentUrl());
	    System.out.println("user is able to login successfully");

	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@DataProvider(name="orangedemologin")
	public Object[][] passData(){
		
		Object[][] data =new Object[3][2];
		//username
		data[0][0]="Admin";
			//password
			data[0][1]="admin123";
			
			data[1][0]="Admin";
			data[1][1]= "admin123";
			
			data[2][0]="Aaradhana";
			data[2][1]="demo456";
			
			return data;
			
		
	}

}
