package webdriverbas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineTracking {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ScreenShotUtil ss = new ScreenShotUtil(driver);

		driver.get("https://www.vfsvisaonline.com/DHAOnlineTracking/OnlineTracking.aspx");
		driver.manage().window().maximize();

		Thread.sleep(4);

		driver.findElement(By.id("ContentMain_txtgwfNumber")).sendKeys("TRA3606056");
		driver.findElement(By.id("ContentMain_txtLastName")).sendKeys("Peta");
		driver.findElement(By.id("ContentMain_btnSubmit")).click();
		ss.takePageScreenShot("Tracking1");

		Thread.sleep(4);

		driver.quit();

	}

}
