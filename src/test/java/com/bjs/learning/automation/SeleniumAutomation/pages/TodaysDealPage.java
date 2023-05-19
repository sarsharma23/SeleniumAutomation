package com.bjs.learning.automation.SeleniumAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDealPage extends BasePage {

	public TodaysDealPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[text()='All Deals']")
	private WebElement _linkAllDeals;
	// getDriver().findElement(By.xpath("//*[text()='All Deals']")).click();
	
	public void clickOnAllDeals() {
		_linkAllDeals.click();
	}

}
