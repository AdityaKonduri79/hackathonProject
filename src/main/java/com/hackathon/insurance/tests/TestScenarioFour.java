package com.hackathon.insurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestScenarioFour extends BasicAutomation{

	@Test
	public void TC020() {
		logger = report.createTest("Test Case Twenty");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		mainPage.selectDate("25/05/2021","25/06/2021");
		elementClick("nextButton_Xpath");
		InsuranceList insList = mainPage.enterPhoneDetails("India", "9832100000");
		insList.destinationEdit("Germany");
		Assert.assertEquals(isElementPresent("CloseBtn_Xpath"), true);
	}
	@Test
	public void TC021() {
		logger = report.createTest("Test Case TwentyOne");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India", "9831200000");
		insList.travellerEdit();
		Assert.assertEquals(isElementPresent("CloseBtn_Xpath"), true);
	
	}
	public void TC022() {
		logger = report.createTest("Test Case TwentyTwo");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India", "9832100000");
		insList.dateEdit();
		Assert.assertEquals(isElementPresent("CloseBtn_Xpath"), true);
	}
	@Test
	public void TC023() {
		logger = report.createTest("Test Case TwentyThree");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India", "9832100000");
		mainPage.elementClick("getQuote_Btn_Xpath");
		insList.sortList();
		insList.selectTopThree();
	}
}
