package com.waitutils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsPrac {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> list = driver.findElements(By.tagName("a"));

		System.out.println(list.size());

		// list.stream().forEach(ele -> System.out.println(ele.getText()));
		
		long startTime = System.currentTimeMillis();
		
		List<String> coll = list.stream().filter(e -> !e.getText().equals("")).map(e -> e.getText())
				.collect(Collectors.toList());

		coll.stream().forEach(e -> System.out.println(e));
		
		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
	}

}
