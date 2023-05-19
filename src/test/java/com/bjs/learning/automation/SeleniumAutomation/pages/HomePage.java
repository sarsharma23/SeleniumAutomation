package com.bjs.learning.automation.SeleniumAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	//Every Page HAS 3 section
	//section 01 :- Constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//section 02 :- Locator
	@FindBy(xpath="//*[@data-csa-c-content-id='nav_cs_gb']")
	private WebElement _linkTodaysdeal;
	
	//section 03:- action on locator
	
	public TodaysDealPage clickOnTodaysDeals() {
		_linkTodaysdeal.click();
		return new TodaysDealPage(getDriver());
	}

}
