package com.waitutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.apsrtconline.in/oprs-web/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("txtJourneyDate")).click();
		List<WebElement> startDates = driver
				.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td[@data-handler='selectDay']"));

		for (WebElement e : startDates) {
			if (e.getText().contains("29")) {
				e.click();
				break;
			}
		}

		Thread.sleep(1500);

		driver.findElement(By.id("txtReturnJourneyDate")).click();

		Thread.sleep(2000);

		String month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();

		while (!month.equals("December")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
		}

		List<WebElement> endDates = driver
				.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]//td[@data-handler='selectDay']"));

		for (WebElement e : endDates) {
			if (e.getText().contains("10")) {
				e.click();
				break;
			}
		}

	}

}
