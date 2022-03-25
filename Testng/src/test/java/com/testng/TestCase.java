package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class TestCase {
	 @Test
	public void TestGoogle() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tarang.agrawal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("cars", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void TestYoutube() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tarang.agrawal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='search']")).sendKeys("cars", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
		
	}

}
