package com.waitutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonkeyTesting {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://yts.mx/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='container']//div[@class='col-xs-20']//ul/li/a"));

		int count = list.size();

		System.out.println(count);

		for (int i = 0; i < count; i++) {

			int random = (int) Math.floor(Math.random() * count);
			System.out.println(random);

			WebElement e = list.get(random);
			System.out.println(e.getText());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(e));

			e.click();

			driver.navigate().back();

			Thread.sleep(1000);

			list = driver.findElements(By.xpath("//div[@class='container']//div[@class='col-xs-20']//ul/li/a"));
		}

		driver.quit();
	}

}
