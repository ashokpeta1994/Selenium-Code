package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		for (WebElement image : images) {
			String source = image.getAttribute("src");
			System.out.println(source);

		}
		driver.quit();
	}

}
