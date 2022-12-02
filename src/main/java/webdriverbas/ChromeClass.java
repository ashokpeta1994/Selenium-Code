package webdriverbas;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		final WebDriver driver = new ChromeDriver();
		driver.get("https:app.hubspot.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign up")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='UIFormControl-2']")).sendKeys("Ashok");
		driver.findElement(By.xpath("//*[@id='UIFormControl-4']")).sendKeys("Peta");
		driver.findElement(By.xpath("//*[@id='UIFormControl-6']")).sendKeys("ashokpeta1378@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[4]/div[1]/div/div/div/div/div[4]/form/div[3]/button"))
				.click();
		Thread.sleep(4000);
	}

	public static WebElement waitFluent(WebDriver driver1, final By locator) {

		Wait<WebDriver> w = new FluentWait<WebDriver>(driver1).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NullPointerException.class);

		final WebElement element = w.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver1) {
				return driver1.findElement(locator);
			}

		});
		return element;
	}
}
