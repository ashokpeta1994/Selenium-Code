package webdriverbas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeckoClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https:app.hubspot.com");
		driver1.manage().window().maximize();
		Thread.sleep(5000);
		driver1.findElement(By.linkText("Sign up")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath("//*[@id='UIFormControl-2']")).sendKeys("Ashok");
		driver1.findElement(By.xpath("//*[@id='UIFormControl-4']")).sendKeys("Peta");
		driver1.findElement(By.xpath("//*[@id='UIFormControl-6']")).sendKeys("ashokpeta1378@gmail.com");
		Thread.sleep(5000);
		driver1.findElement(
				By.xpath("/html/body/div[5]/div[1]/div[4]/div[1]/div/div/div/div/div[4]/form/div[3]/button")).click();
		Thread.sleep(4000);
		driver1.findElement(By.cssSelector(".form-control")).sendKeys("information");
		driver1.quit();

	}

}
