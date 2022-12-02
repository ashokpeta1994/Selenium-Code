package webdriverbas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricBuzz {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		GenericUtil gu = new GenericUtil(driver);
		gu.getUrl(
				"https://www.cricbuzz.com/live-cricket-scorecard/50942/ind-vs-rsa-1st-t20i-south-africa-tour-of-india-2022");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		ScreenShotUtil ss = new ScreenShotUtil(driver);
		ss.takePageScreenShot("cricbuzz1");

		JavaScriptUtil js = new JavaScriptUtil(driver);

		js.refreshBrowserByJS();

		getScoreCard(driver);

		driver.quit();

	}

	public static void getScoreCard(WebDriver driver) {
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

	}

	public static void getWicketTaker(WebDriver driver, String player) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + player
				+ "')]//parent::div//following-sibling::div[contains(@class,'cb-col-33')]"));
		String str = element.getText();
		System.out.println("The wicket taker of " + player + " is " + str);
	}
}
