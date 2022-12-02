package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qafox.com/");
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id='menu-item-1073']/a"));
		WebElement e2 = driver.findElement(By.xpath("//*[@id='menu-item-3293']/a"));

		Actions act = new Actions(driver);

		act.click(e2);
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(By.tagName("iframe"));
		System.out.println(li.size());
		driver.quit();
	}

}
