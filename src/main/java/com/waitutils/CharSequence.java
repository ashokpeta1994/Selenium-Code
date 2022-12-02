package com.waitutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CharSequence {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		StringBuilder sb = new StringBuilder().append("Ashok").append("_").append("peta").append(8)
				.append("@gmail.com");

		String str = "love";

		WebElement ele = driver.findElement(By.id("username"));

		ele.sendKeys(sb, str, Keys.TAB);

		driver.quit();

	}

}
