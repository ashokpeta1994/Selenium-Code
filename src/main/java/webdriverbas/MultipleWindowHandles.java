package webdriverbas;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qafox.com/selenium/selenium-practice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//*[@id='post-481']/div/ul[2]/li[4]/a")).click();
		driver.findElement(By.cssSelector("#post-481 > div > ul:nth-child(5) > li:nth-child(5) > a")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindow = it.next();
		System.out.println(parentWindow);

		String childWindow1 = it.next();
		System.out.println(childWindow1);

		String childWindow2 = it.next();
		System.out.println(childWindow2);

		driver.switchTo().window(childWindow1);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(childWindow2);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
