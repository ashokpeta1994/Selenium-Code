package webdriverbas;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromePopUp {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.qafox.com/selenium/selenium-practice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id='post-481']/div/ul[2]/li[4]/a")).click();

		Set<String> handle = driver.getWindowHandles();

		Iterator<String> it = handle.iterator();

		String parentWindow = it.next();
		System.out.println("The parent window ID is " + parentWindow);

		String childWindow = it.next();
		System.out.println("The child window ID is " + childWindow);

		driver.switchTo().window(childWindow);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindow);

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}
