package com.hackathon.insurance.base;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class InsuranceList extends PageBaseClass {
	
	public InsuranceList(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	public void sortList() {
		selectElementByText("sortList_Xpath","Price: Low to High");
	}
	
	public void selectTopThree() {
		List<WebElement> lowestPrice = getElementsList("priceList_Xpath");
		List<WebElement> insuranceProvider = getElementsList("companyList_Xpath"); 
		Iterator<WebElement> priceIterator = lowestPrice.iterator();
		Iterator<WebElement> providerIterator = insuranceProvider.iterator();
		int counter=0;
		boolean written = false;
		while (priceIterator.hasNext() && providerIterator.hasNext()&& counter<3) {
			WebElement priceElement = (WebElement) priceIterator.next();
			WebElement providerElement = (WebElement) providerIterator.next();
			String provider = providerElement.getAttribute("class").replace("Logo", "");
			String price = priceElement.getText().replace("₹ ", "");
			written = PageBaseClass.setExcelData(provider, price);
			counter++;
			
		}
		Assert.assertEquals(written , true);
	}
	
	public void destinationEdit(String destination){
		elementClick("destinationEdit_Xpath");
		enterText("destinationSearch_Xpath", destination);
		getElement("destinationSearch_Xpath").sendKeys(Keys.ENTER);
		elementClick("applyDestination_Xpath");
	}
	
	public void travellerEdit(){
		elementClick("travellerEdit_Xpath");
	}
	
	public void dateEdit(){
		elementClick("tripDateEdit_Xpath");
	}
	
	
}
