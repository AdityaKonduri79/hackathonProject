package com.hackathon.insurance.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class TestCaseOne extends BasicAutomation {
	
	
	@Test
	public void TC001() { //To check the functionality of "Travel Insurance"  button
		logger = report.createTest("Test Case One- To check the functionality of 'Travel Insurance'  button");		
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.isElementPresent("getQuote_Btn_Xpath");
		mainPage.verifyPageTitle("PolicyBazaar Travel Insurance");
	}
	
	@Test
	public void TC002() { //To check whether the user is able to search for European countries using search bar.
		logger = report.createTest("Test Case Two - To check whether the user is able to search for European countries using search bar.");		
		String[] data = PageBaseClass.getExcelData(2);
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry(data);
	}
	
	@Test
	public void TC003() { //To check whether the user is able to select the preferred European country from the given list.
		logger = report.createTest("Test Case Three - To check whether the user is able to select the preferred European country from the given list.");	
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		String[] data = PageBaseClass.getExcelData(2);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		mainPage.selectCountry(data);
	}
	
	@Test
	public void TC004() { //To check whether user can select more than one European country .
		logger = report.createTest("Test Case Four - To check whether user can select more than one European country .");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountrySearch("Germany");
		mainPage.selectCountrySearch("France");
		elementClick("travellerLabel_Xpath");
		String twoCountries = getElement("twoCountries_Xpath").getAttribute("placeholder");
		Assert.assertEquals(twoCountries.contains("more"), true);
	}
	
	@Test
	public void TC005() { //To check whether user can enter age details of first person in the age dropbox
		logger = report.createTest("Test Case Five - To check whether user can enter age details of first person in the age dropbox");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		String[] data = PageBaseClass.getExcelData(2);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		addWait(10);
		elementClick("travellerLabel_Xpath");
		mainPage.addTraveller(data);
		elementClick("nextButton_Xpath");
		mainPage.selectDate(data);
		String quoteBtnAtr=getElement("getQuoteButton_Id").getAttribute("class");
		Assert.assertEquals(quoteBtnAtr.contains("active"), false);
	}
	
	@Test 
	public void TC006() { //To check the functionality of "Any Pre-Existing Medical Condition" checkbox for thr first traveller.
		logger = report.createTest("Test Case Six - To check the functionality of \"Any Pre-Existing Medical Condition\" checkbox for thr first traveller."); 
		PageBaseClass pageClass = new PageBaseClass(driver,logger); 
		String[] data = PageBaseClass.getExcelData(2);
		HomePage homePage = pageClass.openWebsite(); 
		MainPageForm mainPage = homePage.clickIns(); 
		addWait(10); 
		mainPage.selectCountry(data); 
		mainPage.selectElementByText("firstTravellerAge_Xpath","21 yrs"); 
		logger.log(Status.INFO,"First traveller added"); 
		addWait(10); 
		mainPage.addTraveller(data); 
	} 
	
	@Test 
	public void TC007() { //To check whether the user is able to proceed without giving age value.
		logger = report.createTest("Test Case Seven - To check whether the user is able to proceed without giving age value."); 
		PageBaseClass pageClass = 
		new PageBaseClass(driver,logger); 
		String[] data = PageBaseClass.getExcelData(2);
		HomePage homePage = pageClass.openWebsite(); 
		MainPageForm mainPage = homePage.clickIns(); 
		addWait(10); 
		mainPage.selectCountry(data); 
		elementClick("travellerLabel_Xpath"); 
		mainPage.addTraveller(data); 
		elementClick("medicalCondition_Id"); 
		Assert.assertEquals(isElementSelected("medicalCondition_Id"),true);
	}

}

