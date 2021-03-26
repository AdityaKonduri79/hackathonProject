package com.hackathon.insurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestScenarioThree extends BasicAutomation{
	@Test
	public void TC014(){ //To check the functionality of the "Proceed" button
     	logger = report.createTest("Test Case Fourteen - To check the functionality of the 'Proceed' button");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		Assert.assertEquals(isElementPresent("getQuoteButton_Id"),true);
	}
	
	@Test
	public void TC015(){//To check whether the user can select the preferred country code for giving the mobile number from the drop down list.
		logger = report.createTest("Test Case fifteen - To check whether the user can select the preferred country code for giving the mobile number from the drop down list.");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		addWait(10);
		Assert.assertEquals(isElementPresent("destinationEdit_Xpath"),true);
	}
	
	@Test
	public void TC016(){ //To check whether the user is able to input the details of phone number.
		logger = report.createTest("Test Case sixteen - To check whether the user is able to input the details of phone number.");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		addWait(10);
		Assert.assertEquals(isElementPresent("destinationEdit_Xpath"),true);
		
	}
	@Test
	public void TC017(){//To check the functionality of "View Plans" button.
		logger = report.createTest("Test Case seventeen - To check the functionality of \"View Plans\" button.");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		Assert.assertEquals(isElementPresent("destinationEdit_Xpath"),true);
	}
	
	@Test
	public void TC018(){
		logger = report.createTest("Test Case eighteen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","");
		String quoteBtnAtr = getElement("getQuoteButton_Id").getAttribute("class");
		Assert.assertEquals(quoteBtnAtr.contains("active"), false);
			
	}
	
	@Test
	public void TC019(){ //To check whether the user can view plans without giving an input for mobile number.
		logger = report.createTest("Test Case nineteen - To check whether the user can view plans without giving an input for mobile number.");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","0000000000");
		String quoteBtnAtr = getElement("getQuoteButton_Id").getAttribute("class");
		Assert.assertEquals(quoteBtnAtr.contains("active"), false);
	}
}
