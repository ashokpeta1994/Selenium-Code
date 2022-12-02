package com.waitutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co = new ChromeOptions();
		
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.cricbuzz.com");

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./target/screenshots/mine.png"));

		driver.quit();

	}

}
