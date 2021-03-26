package com.hackathon.insurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestScenarioTwo extends BasicAutomation {
	
	@Test
	public void TC008() { //To check the functionality of "Add Another Traveller" button.
		logger = report.createTest("Test Case Eight - To check the functionality of 'Add Another Traveller' button");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		elementClick("travellerLabel_Xpath");
		Assert.assertEquals(isElementPresent("addTraveller_Btn_Xpath"),true);
	}
	
	@Test
	public void TC009(){ //To check whether user can enter age details of second person in the age dropbox
		logger = report.createTest("Test Case Nine - To check whether user can enter age details of second person in the age dropbox");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("nextButton_Xpath");
		Assert.assertEquals(isElementPresent("dateForward_Btn_Xpath"),true);
		
	}
	
	@Test
	public void TC010(){ //To check the functionality of "Any Pre-Existing Medical Condition" checkbox for the Second traveller
		logger = report.createTest("Test Case Ten - To check the functionality of \"Any Pre-Existing Medical Condition\" checkbox for the Second traveller");
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
	
	@Test
	public void TC011(){ //To check the functionality of Start Date and End Date option under the field - 'Trip Dates'
		logger = report.createTest("Test Case Eleven - To check the functionality of Start Date and End Date option under the field - 'Trip Dates'");
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
	
	@Test
	public void TC012() { //To check whether the user is able to enter the value of  end date before the staring date
		logger = report.createTest("Test Case Twelve - To check whether the user is able to enter the value of  end date before the staring date");
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
	
	@Test
	public void TC013() { //To check functionality of delete button
		logger = report.createTest("Test Case Thirteen - To check functionality of delete button");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller("21 yrs", "22 yrs");
		elementClick("deleteBtn_Xpath");
		Assert.assertEquals(isElementPresent("traveller1_Xpath"), true);
	}
	
	
}
