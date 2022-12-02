package webdriverbas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();

		driver.quit();

	}

}
