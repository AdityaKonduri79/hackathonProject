package com.hackathon.insurance.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class MainPageForm extends PageBaseClass{
	

	public MainPageForm(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	
	
	public void selectCountry(String[] dataSet) {
		selectCountrySearch(dataSet[0]);
		logger.log(Status.PASS, "Country selected succesfully");
	}
	
	public void addTraveller(String[] dataSet) {
		try{
//			elementClick("travellerLabel_Xpath");
			selectElementByText("firstTravellerAge_Xpath", dataSet[1]);
			logger.log(Status.INFO, "First traveller added");
			addWait(10);
			elementClick("addTraveller_Btn_Xpath");
			selectElementByText("secondTravellerAge_Xpath", dataSet[2]);
			logger.log(Status.INFO, "Second traveller added");
		}
		catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	public void selectDate(String[] dataSet) {
		///The date format MUST BE IN "dd/mm/yyyy" FORMAT///
		try{
			selectDates(dataSet[3],dataSet[4]);
			elementClick("getQuote_Btn_Xpath");
			reportPass("Dates selected Succesfully");
		}
		catch(Exception e ) {
			reportFail(e.getMessage());
		}
		
	}
	
	
	public InsuranceList enterPhoneDetails(String[] dataSet) {
		elementClick("countryCode_Xpath");
		enterText("countryCodeName_Xpath",dataSet[5]);
		elementClick("countrycodeSelct_Xpath");
		enterText("mobileNumber_Id",dataSet[6]);
		elementClick("getQuote_Btn_Xpath");
		InsuranceList insList = new InsuranceList(driver, logger);
		PageFactory.initElements(driver, insList);
		return insList;
	}
	
}
