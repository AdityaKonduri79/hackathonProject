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
	public void TC014(){
     	logger = report.createTest("Test Case Fourteen");
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
	public void TC_015(){
		logger = report.createTest("Test Case fifteen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		Assert.assertEquals(isElementEnabled("countryCode_Xpath"),false);
	}
	
	@Test
	public void TC016(){
		logger = report.createTest("Test Case sixteen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		insList.isElementPresent("mobileNumber_Id");	
	}
	@Test
	public void TC017(){
		logger = report.createTest("Test Case seventeen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		insList.elementClick("getQuote_Btn_Xpath");
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
		insList.elementClick("getQuote_Btn_Xpath");
		insList.isElementPresent("sortList_Xpath");
			
	}
	
	@Test
	public void TC019(){
		logger = report.createTest("Test Case nineteen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","0000000000");
		insList.elementClick("getQuote_Btn_Xpath");
	}
}
