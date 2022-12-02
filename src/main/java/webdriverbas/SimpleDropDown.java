package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(3000);
		WebElement day = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]"));
		WebElement month = driver.findElement(
				By.cssSelector("#tblcrtac > tbody > tr:nth-child(23) > td:nth-child(3) > select:nth-child(2)"));
		WebElement year = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]"));

		dropDown(day);
		dropDown(month);
		dropDown(year);

	}
/**
 *
 * @param element
 */
	public static void dropDown(WebElement element) {
		Select sel = new Select(element);
		List<WebElement> li = sel.getOptions();
		for (WebElement element2 : li) {
			String s = element2.getText();
			System.out.println(s);

		}

	}

}
