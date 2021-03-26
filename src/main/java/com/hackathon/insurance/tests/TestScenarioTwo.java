package com.hackathon.insurance.tests;

import org.testng.Assert;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestScenarioTwo extends BasicAutomation {
//	@Test
//	public void testCaseOne() {
//		logger = report.createTest("Test Case One");
//		invokeBrowser("chrome");
//		PageBaseClass pageClass = new PageBaseClass(driver,logger);
//		HomePage homePage = pageClass.openWebsite();
//		MainPageForm mainPage = homePage.clickIns();
//		mainPage.selectCountry("france");
//		mainPage.addTraveller("21 yrs","22 yrs");
//		elementClick("nextButton_Xpath");
//		mainPage.selectDate("25/05/2021","25/06/2021");
//		InsuranceList insList = mainPage.enterPhoneDetails();
//		insList.sortList();
//		insList.selectTopThree();
//
//	}
	
//	@Test
	public void TC008() {
		logger = report.createTest("Test Case Eight");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		elementClick("travellerLabel_Xpath");
		Assert.assertEquals(isElementPresent("addTraveller_Btn_Xpath"),true);
	}
	
	//@Test
	public void TC009(){
		logger = report.createTest("Test Case Nine");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("nextButton_Xpath");
		Assert.assertEquals(isElementPresent("dateForward_Btn_Xpath"),true);
		
	}
	
	//@Test
	public void TC010(){
		logger = report.createTest("Test Case Ten");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		mainPage.selectCountrySearch("germany");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("medicalCondition_Id");
		Assert.assertEquals(isElementSelected("medicalCondition_Id"), true);
		
	}
	
	//@Test
	public void TC011(){
		logger = report.createTest("Test Case Eleven");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021", "25/06/2021");
	}
	
	//@Test
	public void TC012() {
		logger = report.createTest("Test Case Twelve");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/06/2021", "25/05/2021");
		String quoteBtnAtr = getElement("getQuoteButton_Id").getAttribute("class");
		Assert.assertEquals(quoteBtnAtr.contains("active"), false);
	}
	
	//@Test
	public void TC013() {
		logger = report.createTest("Test Case Thirteen");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("deleteBtn_Xpath");
		Assert.assertEquals(isElementPresent("deleteBtn_Xpath"), false);
	}
	
	
}
