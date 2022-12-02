package com.waitutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		List<WebElement> list = driver
				.findElements(By.xpath("//span[@class='a-list-item']//div[contains(@class,'3LeEQ')]"));

		for (WebElement element : list) {
			String text = element.getText();
			System.out.println(text);
		}
	}

}
