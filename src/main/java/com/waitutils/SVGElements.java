package com.waitutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://mapsvg.com/maps/africa");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> list = driver.findElements(
				By.xpath("//div[@class='mapsvg-scrollpane']//*[local-name()='svg' and @id='svg2']/*[name()='path']"));

		Actions acts = new Actions(driver);

		for (WebElement ele : list) {

			acts.moveToElement(ele).perform();

			String str = ele.getAttribute("title");

			if (str.equals("South Africa")) {

				acts.click(ele).build().perform();

				break;
			}

		}
		Thread.sleep(2000);

		driver.quit();

	}

}
