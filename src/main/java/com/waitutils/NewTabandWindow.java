package com.waitutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabandWindow {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		String parentWindow = driver.getWindowHandle();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://youtube.com");
		System.out.println(driver.getCurrentUrl() + " ========== " + driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindow);

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://facebook.com");
		System.out.println(driver.getCurrentUrl() + " ========== " + driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl() + " ========== " + driver.getTitle());
		driver.quit();

	}

}
