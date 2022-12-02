package com.waitutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLess {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver1 = new ChromeDriver(co);

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		WebDriver driver2 = new FirefoxDriver(fo);

		WebDriverManager.edgedriver().setup();
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--headless");
		WebDriver driver = new EdgeDriver(eo);

		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		System.out.println("===================================================");

		driver1.get("https://www.amazon.in");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());

		System.out.println("===================================================");

		driver2.get("https://youtube.com");
		System.out.println(driver2.getTitle());
		System.out.println(driver2.getCurrentUrl());
	}

}
