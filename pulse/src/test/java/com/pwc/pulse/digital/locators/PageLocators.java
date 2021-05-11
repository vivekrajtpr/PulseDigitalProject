package com.pwc.pulse.digital.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * Purpose of this class is to keep all the locators in one location so if there is any change in the locators we don't need to
 * change entire script. We just need to change location in this class only.
 */
public class PageLocators {

	WebDriver driver;

	By click_on_I_Understand_button = By.xpath("//button[@id='js-cookie-button']");
	By click_on_the_X_Icon = By.xpath("(//button[@class='subscribe-modal__close btr bt-times'])[1]");
	By get_the_count_of_articles = By.xpath("//li[@class='flex flex-active-slide']//child::div/div");
	By click_on_the_Next_Arrow_Icon = By.xpath("(//a[@class='flex-next']");
	By click_on_the_Prev_Arrow_Icon = By.xpath("(//a[@class='flex-prev']");
	By click_on_the_Contact_Link1 = By.xpath("(//a[text()='Contact'])[1]");
	By click_on_the_Contact_Link2 = By.xpath("(//a[text()='Contact'])[2]");
	By click_on_the_Contact_Link3 = By.xpath("(//a[text()='Contact'])[3]");
	By click_on_the_Search_Icon = By.xpath("//i[@class='btr bt-search']");
	By enter_search_text = By.id("search-input");

	/*
	 * This initElements method will create all WebElements
	 */
	public PageLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Purpose of this method is to accept the input text as string and entering the
	 * text in the input text field
	 */
	public void enterTextinSearchField(String yourSearchText) {

		driver.findElement(enter_search_text).sendKeys(yourSearchText);

	}

	/*
	 * Purpose of this method is to press the Enter key
	 */
	public void pressEnterKey() {

		driver.findElement(enter_search_text).sendKeys(Keys.ENTER);

	}

	/*
	 * Purpose of this method is to click on search Icon
	 */
	public void clickOnSearchIcon() {

		driver.findElement(click_on_the_Search_Icon).click();

	}

	/*
	 * Purpose of this method is to clicking on contact button on the first card
	 */
	public void clickOnContactButton1() {

		driver.findElement(click_on_the_Contact_Link1).click();

	}

	/*
	 * Purpose of this method is to clicking on contact button on the second card
	 */
	public void clickOnContactButton2() {

		driver.findElement(click_on_the_Contact_Link2).click();

	}

	/*
	 * Purpose of this method is to clicking on contact button on the third card
	 */
	public void clickOnContactButton3() {

		driver.findElement(click_on_the_Contact_Link3).click();

	}

	/*
	 * Purpose of this method is to click "I Understand" button on the popup
	 */
	public void clickOnIUnderstandButton() {

		driver.findElement(click_on_I_Understand_button).click();

	}

	/*
	 * Purpose of this method is to click "X" button on the popup
	 */
	public void clickontheXIcon() {

		driver.findElement(click_on_the_X_Icon).click();

	}

	/*
	 * Purpose of this method is to get the count Articles
	 */
	public void gettheCountofArticles() {

		driver.findElements(get_the_count_of_articles).size();
	}

	/*
	 * Purpose of this method is to click on Next arrow icon
	 */
	public void clickontheNextArrowIcon() {

		driver.findElement(click_on_the_Next_Arrow_Icon).click();

	}

	/*
	 * Purpose of this method is to click on Previous arrow icon
	 */
	public void clickonthePrevArrowIcon() {

		driver.findElement(click_on_the_Prev_Arrow_Icon).click();

	}

}
