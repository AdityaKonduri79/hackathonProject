package com.hackathon.insurance.tests;

import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class ProblemStatementTest extends BasicAutomation {

	@Test
	public void testCaseOne() {
		logger = report.createTest("Test Case One");
		PageBaseClass.getExcelData(2);
		String[] data = PageBaseClass.getExcelData(2);
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry(data);
		mainPage.addTraveller(data);
		elementClick("nextButton_Xpath");
		mainPage.selectDate(data);
		InsuranceList insList = mainPage.enterPhoneDetails(data);
		insList.sortList();
		insList.selectTopThree();
	}
}
