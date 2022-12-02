package webdriverbas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllStaticValues {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://softwaretestingo.blogspot.com/2020/09/static-table.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		List<WebElement> allRows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		System.out.println("Total data rows found in table:" + (allRows.size() - 1));

		for (int i = 2; i <= allRows.size(); i++) {
			List<WebElement> allColumnsInRow = driver
					.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td"));

			for (WebElement element : allColumnsInRow) {
				System.out.print(element.getText() + " ");
			}
			System.out.println();
		}

	}

}
