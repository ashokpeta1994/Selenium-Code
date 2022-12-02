package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link : links) {
			String s = link.getText();
			if (!s.isEmpty()) {
				System.out.println(s);
			}

		}
		driver.quit();

	}
}
