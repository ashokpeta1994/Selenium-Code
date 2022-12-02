package webdriverbas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		int count = driver.findElements(By.xpath("//table[@id='customers']//tr")).size() - 1;
		System.out.println(count);

		String beforePath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterPath = "]/td[1]";

		for (int t = 2; t <= count + 1; t++) {
			String actualPath = beforePath + t + afterPath;
			//System.out.println(actualPath);
			WebElement el = driver.findElement(By.xpath(actualPath));
			System.out.println(el.getText());
		}
		driver.quit();
	}

}
