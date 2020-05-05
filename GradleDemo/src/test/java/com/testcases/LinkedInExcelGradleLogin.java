package com.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkedInExcelGradleLogin {
	@Test
	public void Login() throws InterruptedException, IOException {
		WrapperMethod wm=new WrapperMethod();
		FileInputStream fil=new FileInputStream(new File("C:\\Users\\Shivshankar\\Downloads\\Linkedlogin.xlsx"));
		XSSFWorkbook workbook= new XSSFWorkbook(fil);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int count=sheet.getLastRowNum();
		System.out.println(count);
		for(int i=1;i<=count;i++) {
			XSSFRow row= sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			String un=cell.getStringCellValue();
			XSSFCell cell1=row.getCell(1);
			String pwd=cell1.getStringCellValue();
			
		    Thread.sleep(3000);
		    wm.insertapp("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		    wm.enterbyid("username", un);
		    wm.enterbyid("password", pwd);
		    Thread.sleep(3000);
		    wm.closeapp();
		}
	}

}
