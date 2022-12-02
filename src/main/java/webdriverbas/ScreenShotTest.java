package webdriverbas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		ScreenShotUtil ss = new ScreenShotUtil(driver);

		driver.get("https://amazon.in");

		WebElement str = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(10)"));

		//ss.takePageScreenShot(driver, "HomePage");
		ss.takeElementScreenShot(str, "Header1");

		driver.quit();

	}

}
