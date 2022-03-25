package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fill_form {
	WebDriver driver;

	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\tarang.agrawal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://sqengineer.com/practice-sites/basic-web-elements/");
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
	public void form_details() {
		driver.findElement(By.id("firstName")).sendKeys("qwerty");
	    driver.findElement(By.cssSelector("input#lastName")).sendKeys("asdfgh");
	    driver.findElement(By.xpath("//input[@id='maleGender']")).click();
	    driver.findElement(By.id("country")).click();
	    driver.findElement(By.id("status")).click();
	    driver.findElement(By.id("email")).sendKeys("qwerty.asdfgh@yopmail.com");
	    Select se = new Select(driver.findElement(By.id("selectBox")));
	    se.selectByIndex(3);
	    driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}
