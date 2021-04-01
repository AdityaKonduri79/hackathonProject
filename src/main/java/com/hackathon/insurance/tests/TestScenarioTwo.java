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
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry(data);
		elementClick("travellerLabel_Xpath");
		Assert.assertEquals(isElementPresent("addTraveller_Btn_Xpath"),true);
	}
	
	@Test
	public void TC009(){ //To check whether user can enter age details of second person in the age dropbox
		logger = report.createTest("Test Case Nine - To check whether user can enter age details of second person in the age dropbox");
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		mainPage.addTraveller(data);
		elementClick("nextButton_Xpath");
		Assert.assertEquals(isElementPresent("dateForward_Btn_Xpath"),true);
		
	}
	
	@Test
	public void TC010(){ //To check the functionality of "Any Pre-Existing Medical Condition" checkbox for the Second traveller
		logger = report.createTest("Test Case Ten - To check the functionality of \"Any Pre-Existing Medical Condition\" checkbox for the Second traveller");
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		mainPage.selectCountrySearch("germany");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller(data);
		elementClick("medicalCondition_Id");
		Assert.assertEquals(isElementSelected("medicalCondition_Id"), true);
		
	}
	
	@Test
	public void TC011(){ //To check the functionality of Start Date and End Date option under the field - 'Trip Dates'
		logger = report.createTest("Test Case Eleven - To check the functionality of Start Date and End Date option under the field - 'Trip Dates'");
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller(data);
		elementClick("nextButton_Xpath");
		mainPage.selectDate(data);
	}
	
	@Test
	public void TC012() { //To check whether the user is able to enter the value of  end date before the staring date
		logger = report.createTest("Test Case Twelve - To check whether the user is able to enter the value of  end date before the staring date");
		String[] data = PageBaseClass.getExcelData(3);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller(data);
		elementClick("nextButton_Xpath");
		mainPage.selectDate(data);
		String quoteBtnAtr = getElement("getQuoteButton_Id").getAttribute("class");
		Assert.assertEquals(quoteBtnAtr.contains("active"), false);
	}
	
	@Test
	public void TC013() { //To check functionality of delete button
		logger = report.createTest("Test Case Thirteen - To check functionality of delete button");
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("france");
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller(data);
		elementClick("deleteBtn_Xpath");
		Assert.assertEquals(isElementPresent("traveller1_Xpath"), true);
	}
	
	
}
