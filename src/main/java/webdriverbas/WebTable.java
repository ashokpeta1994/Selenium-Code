package webdriverbas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/43206/pak-vs-eng-final-icc-mens-t20-world-cup-2022");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		List<WebElement> names = driver.findElements(By.xpath(
				"(//div[text()='Batter'])[2]/..//following-sibling::div//div[contains(@class,'cb-col-27')]//a[contains(@href,'profiles')]"));

		for (WebElement name : names) {

			String s = name.getText();

			System.out.print(s + "   " + "\t");

			List<WebElement> list = driver.findElements(By.xpath("//a[contains(text(),'" + s
					+ "')]//parent::div//following-sibling::div[contains(@class,'cb-col-8')]"));

			for (WebElement element : list) {

				System.out.print(element.getText() + "  ");
			}

			System.out.println();
		}
		driver.quit();
	}

}
