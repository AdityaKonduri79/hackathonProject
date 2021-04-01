package com.hackathon.insurance.base;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hackathon.insurance.utils.DateUtils;
import com.hackathon.insurance.utils.ReadExcelFile;

public class PageBaseClass extends BasicAutomation{

	
	public ExtentTest logger;
	public static ReadExcelFile excel;
	
	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/****************************************************
						OPEN WEBSITE
	******************************************************/
	public HomePage openWebsite(){
	HomePage homePage = null;
	try {
		homePage = new HomePage(driver,logger);
		openURL("websiteURL");
		reportPass("Website opened succesfully");
	} 
	catch (Exception e) {
		reportFail(e.getMessage());
	}
	
	return homePage;
	}
	
	/************************************************
				Handle Unexpected Ad
	 ***********************************************/
	public void handleAd(String closeBtnLocator) {
		try {
			addWait(20);
			clickByJavascript(closeBtnLocator);
			reportPass("Ad closed successfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
	
		}
	}
	
	/****************************************************
	 					SELECT COUNTRIES
	 ****************************************************/
	public void selectCountrySearch( String country) {
//		excel = new ReadExcelFile(System.getProperty("user-dir")+"\\test-output\\data-sheet.xlsx");
		//String country = excel.getCellData("Input-data", colNum, rowNum);
		addWait(10);
		elementClick("anotherCountry_Xpath");
		enterText("countrySearch_Xpath",  country);
		String countryCapitalize = country.substring(0,1).toUpperCase() + country.substring(1);
		driver.findElement(By.xpath(prop.getProperty("countrySelect_Xpath").replace("France",countryCapitalize))).click();
		
	}
	/****************************************************
	 					SELECT DATES
	 ****************************************************/
	public void selectDates(String startDate, String endDate) {
		 try
		    {
		      //create SimpleDateFormat object with source string date format
		      SimpleDateFormat sdfSource = new SimpleDateFormat("dd-MM-yyyy");
		      //parse the string into Date object
		      Date sdate = sdfSource.parse(startDate);
		      Date edate = sdfSource.parse(endDate);
		      //create SimpleDateFormat object with desired date format
		      SimpleDateFormat sdfDestination = new SimpleDateFormat("dd MMMMM yyyy");
		      //parse the date into another format
		      String startConvDate = sdfDestination.format(sdate);
		      String endConvDate = sdfDestination.format(edate);
		      
		      if(!startDate.contains("/04/") || !startDate.contains("/05/"))
		      {
		    	  int n = Integer.parseInt(endDate.substring(3, 5)) - 5;		    			  
		    	  for (int i = 0; i <= n; i++) {
		    		System.out.println(i);
					elementClick("dateForward_Btn_Xpath");
					addWait(5);
		    	  }
		    	  
		      }
		      System.out.println(startConvDate);
		      System.out.println(startConvDate.substring(3));
		      String dynamicStartDate = prop.getProperty("startDatePick_Xpath").replace("April 2021",startConvDate.substring(3)).replace("3", startConvDate.substring(0,2));
		      System.out.println("Element Clicked");
		      String dynamicEndDate = prop.getProperty("endDatePick_Xpath").replace("April 2021",endConvDate.substring(3)).replace("25", endConvDate.substring(0,2));
		      addWait(10);
		      JavascriptExecutor jse = (JavascriptExecutor) driver;
		      WebElement startDateElement = driver.findElement(By.xpath(dynamicStartDate));
		      WebElement endDateElement = driver.findElement(By.xpath(dynamicEndDate));
		      jse.executeScript("arguments[0].click()",startDateElement);
		      jse.executeScript("arguments[0].click()",endDateElement);
	    	}
		    catch(ParseException pe)
		    { 
		      System.out.println("Parse Exception : " + pe);
		    }
	}
	
	
	public static boolean setExcelData(String provider, String amount) {
		excel = new ReadExcelFile(System.getProperty("user.dir")+
				"\\src\\test\\resources\\ObjectRepositiory\\dataSheet.xlsx");
		int i = excel.getLastRow("OutputData")+2;
		
		excel.setCellData("OutputData", "Provider Name", i, provider);
		boolean done = excel.setCellData("OutputData", "Price", i, amount);
		return done;
	}
	
	public static String[] getExcelData(int rowNum) {
		String[] data = new String[30];
		excel = new ReadExcelFile(System.getProperty("user.dir")
			+ "\\src\\test\\resources\\ObjectRepositiory\\dataSheet.xlsx");
	for(int colNum=0; colNum<excel.getColumnCount("InputData") ; colNum++) {
		data[colNum] = excel.getCellData("InputData",colNum , rowNum);
	}
	
	return data;
		
	}
	/****************************************************
	 					SELECT ELEMENT
	 ****************************************************/
	///SELECT BY VISIBLE TEXT
	public void selectElementByText(String locatorKey, String textValue) {
		try {
		Select select = null;
		select = new Select(getElement(locatorKey));
		select.selectByVisibleText(textValue);
		reportPass("Option with value "+ textValue +" selected succesfully");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}

	/// Select by Index
	public void selectElementByIndex(String locatorKey, int index) {
		try {
			Select select = null;
			select = new Select(getElement(locatorKey));
			select.selectByIndex(index);
			reportPass("Option at "+index+" selected succesfully");
		
			}
			catch(Exception e) {
				reportFail(e.getMessage());
			}
	}

	/************************************************
	 					VERIFY TITLE
	 ***********************************************/
	public void verifyPageTitle(String pageTitle) {
		try {
			String actualTitle = driver.getTitle();
			logger.log(Status.INFO, "Actual Title is : " + actualTitle);
			logger.log(Status.INFO, "Expected Title is : " + pageTitle);
			Assert.assertEquals(actualTitle, pageTitle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*********************************************** 
	  					TEST REPORT 
	 ***********************************************/
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}
	/*********************************************** 
					Take Screenshot 
	 ***********************************************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(
				System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.dateFormatstamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.dateFormatstamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
}