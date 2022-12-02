package com.waitutils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> list = driver.findElements(
				By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g'] "));

		Actions act = new Actions(driver);

		for (WebElement element : list) {
			act.moveToElement(element).perform();
			String sn = element.getAttribute("id");
			System.out.println(sn);

			if (sn.equals("massachusetts")) {
				act.click(element).build().perform();
				break;
			}
		}
		Thread.sleep(2000);

		List<WebElement> list1 = driver.findElements(By.xpath(
				"//div[@id='map-component']//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']"
						+ "/*[name()='g' and @id='massachusetts']/*[local-name()='g' and @class='counties']/*[name()='path']"));

		for (WebElement e : list1) {
			act.moveToElement(e).perform();
			String s1 = e.getAttribute("id");
			
			if (s1.equals("25017")) {
				act.click(e).build().perform();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
