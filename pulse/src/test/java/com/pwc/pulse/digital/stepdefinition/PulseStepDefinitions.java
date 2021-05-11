package com.pwc.pulse.digital.stepdefinition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pwc.pulse.digital.locators.PageLocators;
import com.pwc.pulse.digital.utilities.ReadData;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class PulseStepDefinitions {

	// Creating object of ReadData()
	ReadData loadTestData = new ReadData();

	WebDriver driver; // creating webdriver object

	@Given("I navigate to the PwC Digital Pulse website")
	public void i_navigate_to_the_PwC_Digital_Pulse_website() {

		/*
		 * Using WebDriverManager so that whenever version of browser is updated then we
		 * don't need to manually download the chrome driver. This will automatically
		 * download the driver
		 */
		WebDriverManager.chromedriver().setup();

		// create an instance of WebDriver
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Maximum 20 seconds it will wait to load the entire page
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// Maximize the browsers
		driver.manage().window().maximize();

		// Fetching the URL from config properties file
		driver.get(loadTestData.readPropfie().getProperty("url"));

	}

	/*
	 * This method will accept the String as parameter and validate the header of
	 * the page
	 */
	@When("I am viewing the {string} page")
	public void i_am_viewing_the_page(String string) {

		String actualTitle = driver.getTitle();
		//System.out.println("Actual Title => " + actualTitle);
		String expectedTitle = "Digital Pulse - Disruption, Innovation and Industry Change";

		// verify the user is on the Home Page.
		assertEquals(actualTitle, expectedTitle);

	}

	/*
	 * This method will accept the integer value of parameter and validating 3
	 * carousel features are displaying
	 */
	@Then("I am presented with a carousel displaying {int} featured articles")
	public void i_am_presented_with_a_carousel_displaying_featured_articles(Integer int1) {

		PageLocators locatores = new PageLocators(driver);

		// click on I Understand button of the popup
		locatores.clickOnIUnderstandButton();

		// Click on the 'X' Icon of the popup
		locatores.clickontheXIcon();

		// Store the total count of carousel features
		int articlesCounts = driver.findElements(By.xpath("//li[@class='flex flex-active-slide']//child::div/div"))
				.size();
		int intExpectedValues = int1.intValue();

		//System.out.println("Total articles counts are => " + articlesCounts);
		Assert.assertEquals(articlesCounts, intExpectedValues);

	}

	/*
	 * This method will accept the String and integer value as parameter and
	 * clicking on the next button and Validating next page's carousel is displaying
	 * 3 featured articles
	 */
	@Then("Clicking the {string} button on the carousel will load the next {int} featured articles")
	public void clicking_the_button_on_the_carousel_will_load_the_next_featured_articles(String string, Integer int1) {

		// click on the Next Arrow icon
		driver.findElement(By.xpath("//a[@class='flex-next']")).click();

		// Store the total count of carousel features
		int articlesCounts = driver.findElements(By.xpath("//li[@class='flex flex-active-slide']//child::div/div"))
				.size();
		//System.out.println("Actual count is => " + articlesCounts);

		int intExpectedValues = int1.intValue();
		//System.out.println("Expected count is => " + intExpectedValues);

		// validating the Articles count is 3
		Assert.assertEquals(articlesCounts, intExpectedValues);

	}

	/*
	 * This method will accept the String and integer value as parameter and
	 * clicking on the next button and Validating next page's carousel is displaying
	 * 3 featured articles
	 */
	@Then("Clicking the {string} button on the carousel will load the previous {int} featured articles")
	public void clicking_the_button_on_the_carousel_will_load_the_previous_featured_articles(String string,
			Integer int1) throws InterruptedException {
		// sync the with contact page.
		Thread.sleep(1000);

		// clicking on the Previous Arrow icon
		driver.findElement(By.xpath("//a[@class='flex-prev']")).click();

		// Store the total count of carousel features
		int articlesCounts = driver.findElements(By.xpath("//li[@class='flex flex-active-slide']//child::div/div"))
				.size();
		int intExpectedValues = int1.intValue();

		// Validating the count of previous articles should be 3
		Assert.assertEquals(articlesCounts, intExpectedValues);

		Thread.sleep(2000);
		// Fetch and story the text value first articles
		String articleText1 = driver.findElement(By.xpath("(//span[@class='article-type']//following::h2)[4]"))
				.getText();
		System.out.println("First text value is => " + articleText1);

		// Validating the first feature value
		// Here we are fetching the expected data value from external file
		// So that tomorrow if text is changed then we don't need to change the scripts,
		// we just need to update the external file
		Assert.assertEquals(articleText1, loadTestData.readTestData().getProperty("expectedMsg1"));

		// Fetch and story the text value second articles
		String articleText2 = driver.findElement(By.xpath("(//span[@class='article-type']//following::h2)[5]"))
				.getText();
		//System.out.println("Second text value is => " + articleText2);

		// Validating the second feature value
		// Here we are fetching the expected data value from external file
		// So that tomorrow if text is changed then we don't need to change the scripts,
		// we just need to update the external file
		Assert.assertEquals(articleText2, loadTestData.readTestData().getProperty("expectedMsg2"));

		// Fetch and story the text value third articles
		String articleText3 = driver.findElement(By.xpath("(//span[@class='article-type']//following::h2)[6]"))
				.getText();
		//System.out.println(articleText3);

		// Validating the third feature value
		// Here we are fetching the expected data value from external file
		// So that tomorrow if text is changed then we don't need to change the scripts,
		// we just need to update the external file
		Assert.assertEquals(articleText3, loadTestData.readTestData().getProperty("expectedMsg3"));

		// Close the current browser.
		driver.close();

	}

	// Second Scenarios
	/*
	 * This method accepts string value as parameter Purpose of this method is to Go
	 * to Hamburger menu and click on the Contact us link
	 */
	@When("I select {string} from the hamburger menu")
	public void i_select_from_the_hamburger_menu(String string) {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		PageLocators locatores = new PageLocators(driver);

		// click on I Understand button of the popup
		locatores.clickOnIUnderstandButton();

		// Click on the 'X' Icon of the popup
		locatores.clickontheXIcon();

		// clicking on the Hamburger menu
		driver.findElement(By.xpath("//i[@class='btr bt-bars trigger']")).click();

		// Click on the Contact us link
		driver.findElement(By.xpath("(//a[text()='Contact us'])[1]")).click();
	}

	/*
	 * This method accepts string value as parameter. Purpose of this method is to
	 * validate the header of Contact Us page
	 */
	@Then("I am taken to the {string} page")
	public void i_am_taken_to_the_page(String string) {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		String actualTitle = driver.getTitle();
		System.out.println("actual title is => " + actualTitle);

		String expectedTitle = "Contact us - Digital Pulse";
		//System.out.println("Expected title is => " + expectedTitle);

		// Validating the header message of the Contact us page
		assertEquals(actualTitle, expectedTitle);

	}

	/*
	 * This method will not accept any value as parameter. Purpose of this method
	 * Click on all the four links and Validate the URL's and Header value of the
	 * newly open tabs
	 */
	@And("I am presented with the below options for contacts")
	public void i_am_presented_with_the_below_options_for_contacts() throws InterruptedException {
		PageLocators locatores = new PageLocators(driver);
		Thread.sleep(3000);
		locatores.clickOnContactButton1();
		Thread.sleep(3000);

		// Pressing control+t button to open in new tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		// Storing all the tabs in arrayList
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		// switches to newly open tab
		driver.switchTo().window(tabs.get(1));

		// Fetch the current URL and storing the value
		String url = driver.getCurrentUrl();
		//System.out.println("URL is => " + url);
		Thread.sleep(3000);

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(url, loadTestData.readTestData().getProperty("experienceCenterUrl"));

		Thread.sleep(3000);
		// Switching to main browser
		driver.switchTo().window(tabs.get(0));

		// Clicking on the the second button
		locatores.clickOnContactButton2();

		// Storing the tabs value in array list
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		// Switching to the second tab
		driver.switchTo().window(tabs2.get(2)); // switches to new t
		Thread.sleep(3000);

		// Fetch the current URL and store in variable
		String careerUrl = driver.getCurrentUrl();
		//System.out.println("CareerUrl  => " + careerUrl);

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(careerUrl, loadTestData.readTestData().getProperty("careersUrl"));

		// Switching to main browser
		driver.switchTo().window(tabs2.get(0));

		// Opening the new tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		Thread.sleep(3000);

		// Clicking on the Contact button
		locatores.clickOnContactButton3();

		// Storing the tabs value in array list
		ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());

		// switches to new tab
		driver.switchTo().window(tabs3.get(3));
		Thread.sleep(3000);

		// Fetch the current URL and store in variable
		String enquiryUrl = driver.getCurrentUrl();
		//System.out.println("EnquiriesUrl => " + enquiryUrl);

		// Validating the newly open tab and fetching the expected value from external
		// file
		Assert.assertEquals(enquiryUrl, loadTestData.readTestData().getProperty("enquiriesUrl"));

		// switches to main window
		driver.switchTo().window(tabs.get(0));
		driver.quit();

	}

	// Third Scenarios
	/*
	 * This method accept the String value as parameter and closing all the popups
	 */
	@When("I click on the {string} icon to perform a search")
	public void i_click_on_the_icon_to_perform_a_search(String string) {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		PageLocators locatores = new PageLocators(driver);

		// click on I Understand button of the popup
		locatores.clickOnIUnderstandButton();

		// Click on the 'X' Icon button of the popup
		locatores.clickontheXIcon();
		locatores.clickOnSearchIcon();

	}

	/*
	 * This method accept the String value as parameter and Entering the accepted
	 * input parameter as input to the text field
	 */
	@When("I enter the text {string}")
	public void i_enter_the_text(String string) {

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		PageLocators locatores = new PageLocators(driver);

		locatores.enterTextinSearchField(string);

	}

	/*
	 * This method will not accept any parameter and Pressing the enter key after
	 * entering the value
	 */
	@When("I submit the search")
	public void i_submit_the_search() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		PageLocators locatores = new PageLocators(driver);

		// Calling the pressEnterKey()
		locatores.pressEnterKey();

	}

	/*
	 * This method will not accept any parameter and Validating the header of Search
	 * result page
	 */
	@Then("I am taken to the search results page")
	public void i_am_taken_to_the_search_results_page() {

		// Fetch and story the text value third articles
		String serachText = driver.findElement(By.xpath("(//span)[1]")).getText();

		// Validating the Header value of Search result page
		Assert.assertEquals(serachText, "Showing search results for");

	}

	/*
	 * This method will accept int value as parameter Validating the search result
	 * is showing at least 1 search result
	 */
	@Then("I am presented with at least {int} search result")
	public void i_am_presented_with_at_least_search_result(Integer int1) {

		int noOfResult = driver.findElements(By.xpath("//h2/a")).size();
		//System.out.println("Number of results => " + noOfResult);

		int intExpectedValues = int1.intValue();
		//System.out.println("Number of Expected results => " + intExpectedValues);

		// Validating the search result is showing at least 1 search result
		Assert.assertTrue(noOfResult >= intExpectedValues);

		driver.quit();

	}

}
