package webdriverbas;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildToChild {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qafox.com/selenium/selenium-practice/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='post-481']/div/ul[1]/li[2]/a")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		String parentWindow = it.next();
		System.out.println("The parent window ID is " + parentWindow);

		String childWindow = it.next();
		System.out.println("The child window ID is " + childWindow);

		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("#HTML37 > div.widget-content > p > a")).click();
		driver.close();

		String childWindow1 = it.next();
		System.out.println("The child window1 ID is " + childWindow1);

		driver.switchTo().window(childWindow1);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
