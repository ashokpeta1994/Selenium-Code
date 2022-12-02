package webdriverbas;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickOption {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

		Actions act = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector("#authentication > span"));

		act.contextClick(we).build().perform();

		List<WebElement> list = driver.findElements(By.className("context-menu-icon"));
		//System.out.println(list.size());
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement element : list) {
			String str = element.getText();
			al.add(str);

		}
		for (String e : al) {
			System.out.println(e);

		}

		driver.quit();

	}

}
