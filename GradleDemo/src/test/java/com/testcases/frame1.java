package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frame1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Shivshankar\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/draggable/");




		System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
			
		driver.switchTo().defaultContent(); 

							
		driver.findElement(By.linkText("Droppable")).click();


		driver.close();
			


	}

}
