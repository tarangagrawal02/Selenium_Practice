package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;

public class makemytrip {
	WebDriver driver;

	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\tarang.agrawal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

	}

	public void logMessage(String message) {
		Reporter.log(message, true);
	}

	@BeforeTest
	public void initialize() {
		init();
	}

	@Test
	public void step_1_TestLogo() throws Exception {
		WebElement logo = driver.findElement(By.cssSelector("img[alt=\"Make My Trip\"]"));
		assertTrue(logo.isDisplayed(), "Assert Fail: Image is not displaying");
		logMessage("Assert Pass: Image is displaying");
	}

	@Test
	public void step_2_closepopup() throws Exception {
		WebElement popup = driver.findElement(By.cssSelector("div[class=\"langCard  fixedCard bounceAni\"]"));
		assertTrue(popup.isDisplayed(), "Assert Fail: Popup is not displayed");
		driver.findElement(By.cssSelector("span[class=\"langCardClose\"]")).click();
		logMessage("Assert Pass: popup is closed");

	}

	@Test
	public void step_3_onewayselected() throws Exception {
		WebElement oneway = driver.findElement(By.xpath("//li[@data-cy=\"oneWayTrip\" and @class=\"selected\"]"));
		String s = oneway.getAttribute("class");
		System.out.println(s);
		assertTrue(s.equals("selected"), "Assert Fail: Oneway not selected");
		logMessage("Assert Pass: Oneway is selected");
	}

	@Test
	public void step_4_date() {
		String date = driver.findElement(By.cssSelector("span[class=\"font30 latoBlack\"]")).getText();
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDate = currentDate.plusDays(1);
		String ndate = nextDate.toString();
		String[] day = ndate.split("-");
		System.out.println(nextDate);
		System.out.println(day[2]);
		assertTrue(day[2].equals(date), "Assert Fail: Wrong Date ");
		logMessage("Assert Pass: Correct date");

	}

	//@AfterClass
	public void closeBrowserSession() {
		driver.quit();
		logMessage("The browser is closed.");
	}
}
