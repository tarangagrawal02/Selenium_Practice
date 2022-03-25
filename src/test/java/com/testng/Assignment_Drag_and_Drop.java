package com.testng;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_Drag_and_Drop {
	WebDriver driver;
	WebElement dragbox;
	WebElement dropbox;
	String colorbeforeDnD;

	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\tarang.agrawal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

	}

	//public void frame_switch() {
		//WebElement webframe = driver.findElement(By.className("\"demo-frame\""));
		//driver.switchTo().frame(webframe);
	//}

	public void logMessage(String message) {
		Reporter.log(message, true);
	}

	@BeforeTest
	public void initialize() {
		init();
		//frame_switch();
	}

	@Test
	public void step_1_draggablebox() {
		WebElement webFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(webFrame);
		this.dragbox = driver.findElement(By.xpath("//p[text()=\"Drag me to my target\"]"));
		assertTrue(dragbox.isDisplayed(), "Assert Fail: No draggable box");
		logMessage("Assert Pass: Found draggable box");
	}

	@Test
	public void step_2_dropabblebox() {
		this.dropbox = driver.findElement(By.cssSelector("div[id=\"droppable\"]"));
		this.colorbeforeDnD = dropbox.getCssValue("color");
		assertTrue(dropbox.isDisplayed(), "Assert Fail: No droppable box");
		logMessage("Assert Pass: Found droppable box");
	}

	@Test
	public void step_3_drag_source_to_target() {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragbox, dropbox).build().perform();
		logMessage("Box Dragged");
	}
	@Test
	public void step_4_colorchange() {
		String colorAfterDnD = dropbox.getCssValue("color");
		assertTrue(colorAfterDnD.equals("rgba(119, 118, 32, 1)"), "Assert Fail: Colour didn't changed");
		logMessage("Assert Pass: Colour changed");
	}
	@Test
	public void step_5_textchange() {
		String text = dropbox.getText();
		assertTrue(text.equals("Dropped!"), "Assert Fail: Text didn't changed");
		logMessage("Assert Pass: Text changed");
	}

}
