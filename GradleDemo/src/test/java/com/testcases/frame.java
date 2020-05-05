package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class frame {
	@Test
	public void dragmethod() throws InterruptedException {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Shivshankar\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    WebDriver driver=new FirefoxDriver();
	
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://jqueryui.com/droppable/");
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
			
	Actions builder = new Actions(driver);
	builder.dragAndDrop(drag, drop).build().perform();
	}
}
