package com.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class googlesearch {
	@Test
	public void countinglinksingooglepage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shivshankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    

	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input "));
		element.sendKeys("testing");
		driver.findElement(By.name("btnK")).click();

		
		Thread.sleep(3000);
		List<WebElement> lstlink=driver.findElements(By.xpath("//a"));
		int no_of_link=lstlink.size();
		System.out.println("The number of links found in gooogle search is =" + no_of_link);
		driver.close();

	}

}
