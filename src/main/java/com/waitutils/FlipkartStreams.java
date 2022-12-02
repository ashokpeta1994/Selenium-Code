package com.waitutils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartStreams {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());

		long startTime = System.currentTimeMillis();
		// linkList.stream().forEach(e -> System.out.println(e.getText()));

		List<String> modList = linkList.stream().filter(e -> !e.getText().equals("")).map(e -> e.getText())
				.collect(Collectors.toList());
		
		System.out.println(modList.size());

		modList.stream().forEach(e -> System.out.println(e));

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		
		driver.quit();
	}

}
