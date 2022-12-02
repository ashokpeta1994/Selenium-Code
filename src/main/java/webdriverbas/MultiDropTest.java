package webdriverbas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiDropTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("justAnInputBox")).click();

		By drop = By.xpath("//div[@class='comboTreeDropDownContainer']//ul//li/span[@class='comboTreeItemTitle']");

		MultiDropUtil obj = new MultiDropUtil(driver);
		obj.multiSelectDropDown(drop, "all");

		driver.quit();

	}

}
