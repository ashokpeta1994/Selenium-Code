package com.waitutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//input[@title='Search']"));
		element.click();

		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();

	}

}
