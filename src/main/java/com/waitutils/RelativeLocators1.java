package com.waitutils;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators1 {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

		WebElement ele = driver.findElement(By.xpath("(//table[@id='customers']//tr//td)[1]"));

		List<WebElement> list = driver.findElements(with(By.tagName("td")).toRightOf(ele));

		list.stream().forEach(e -> System.out.println(e.getText()));

//		String right = driver.findElement(with(By.tagName("td")).toRightOf(ele)).getText();
//		System.out.println(right);
//
//		System.out.println("=============================================");
//
//		String left = driver.findElement(with(By.tagName("td")).toLeftOf(ele)).getText();
//		System.out.println(left);
//
//		System.out.println("=============================================");
//
//		String below = driver.findElement(with(By.tagName("td")).below(ele)).getText();
//		System.out.println(below);

		driver.quit();
	}

}
