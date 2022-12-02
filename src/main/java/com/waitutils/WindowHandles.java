package com.waitutils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
		driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();
		driver.findElement(By.xpath("(//a[@target='_blank'])[3]")).click();
		driver.findElement(By.xpath("(//a[@target='_blank'])[4]")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String childWindow = it.next();
			if (!childWindow.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getCurrentUrl() + " and " + driver.getTitle());
				driver.close();
			}
		}

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl() + " and " + driver.getTitle());
		driver.quit();
	}

}
