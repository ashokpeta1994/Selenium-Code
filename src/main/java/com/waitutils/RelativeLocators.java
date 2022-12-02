package com.waitutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/53338/pakw-vs-slw-semi-final-2-womens-asia-cup-t20-2022");

		WebElement ele = driver.findElement(By
				.xpath("(//div[@id='innings_1']//div[contains(@class,'cb-scrd-itms')]//a[@class='cb-text-link'])[1]"));
		System.out.println(ele.getText());

		List<WebElement> list = driver
				.findElements(with(By.xpath("//div[contains(@class,'text-right')]")).toRightOf(ele));

		list.stream().forEach(e -> System.out.println(e.getText()));
	}

}
