package com.hackathon.insurance.tests;

import org.testng.annotations.Test;

import com.hackathon.insurance.base.BasicAutomation;
import com.hackathon.insurance.base.HomePage;
import com.hackathon.insurance.base.InsuranceList;
import com.hackathon.insurance.base.MainPageForm;
import com.hackathon.insurance.base.PageBaseClass;

public class ProblemStatementTest extends BasicAutomation {
//	@Test
	public void testCaseOne() {
		logger = report.createTest("Test Case One");
		invokeBrowser("chrome");
		PageBaseClass pageClass = new PageBaseClass(driver,logger);
		HomePage homePage = pageClass.openWebsite();
		MainPageForm mainPage = homePage.clickIns();
		mainPage.selectCountry("france");
		mainPage.addTraveller("21 yrs","22 yrs");
		elementClick("nextButton_Xpath");
		mainPage.selectDate("25/05/2021","25/06/2021");
		InsuranceList insList = mainPage.enterPhoneDetails("India","9876543210");
		insList.sortList();
		insList.selectTopThree();

	}
}
